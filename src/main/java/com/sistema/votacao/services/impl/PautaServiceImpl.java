package com.sistema.votacao.services.impl;


import com.sistema.votacao.domain.Pauta;
import com.sistema.votacao.repositories.PautaRepository;
import com.sistema.votacao.services.PautaService;
import com.sistema.votacao.services.dto.PautaDTO;
import com.sistema.votacao.services.dto.PautaVotadaDTO;
import com.sistema.votacao.services.dto.ResultadoPautaEleitaDTO;
import com.sistema.votacao.services.exception.ObjectNotFoundException;
import com.sistema.votacao.services.utils.MensagensUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PautaServiceImpl implements PautaService {

    private final Logger log = LoggerFactory.getLogger(PautaService.class);

    private final PautaRepository pautaRepository;

    @Override
    public void savePauta(PautaDTO pautaDTO) {
        log.debug("Cadastrando uma nova pauta {}", pautaDTO);
        pautaRepository.save(setPautaFromPautaDTO(pautaDTO));
    }

    private Pauta setPautaFromPautaDTO(PautaDTO pautaDTO) {
        Pauta pauta = new Pauta();
        pauta.setDescricao(pautaDTO.getDescricao());
        pauta.setVersao(pautaDTO.getVersao());
        pauta.setDataCriacao(pautaDTO.getDataCriacao());
        pauta.setVotada(false);
        return pauta;
    }

    @Override
    public void updatePauta(PautaVotadaDTO pautaVotadaDTO) {
        log.debug("Atualizando a votacao da pauta {}", pautaVotadaDTO);
        Pauta pauta = findByIdPauta(pautaVotadaDTO.getId());
        updateData(pautaVotadaDTO, pauta);
        pautaRepository.save(pauta);
    }

    private void updateData(PautaVotadaDTO pautaVotadaDTO, Pauta pauta) {
        pauta.getVotacoes().addAll(pautaVotadaDTO.getVotacoes());
        pauta.setVotada(true);
    }

    @Override
    public Pauta findByIdPauta(Integer id) {
        log.debug("Buscar pauta pelo id {}", id);
        return pautaRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException(MensagensUtils.PAUTA_NAO_ENCONTRADA + id));
    }

    @Override
    public Page<Pauta> findPagePauta(Integer page, Integer linesPerPage) {
        log.debug("Paginacao da pauta", page, linesPerPage);
        PageRequest pageRequest = PageRequest.of(page, linesPerPage);
        return pautaRepository.findAll(pageRequest);
    }

    @Override
    public List<PautaDTO> findAllPautas() {
        log.debug("Buscar todas as pautas");
        return pautaRepository.findAll().stream().filter(pauta -> pauta != null).map(PautaDTO::new).collect(Collectors.toList());
    }

    @Override
    public ResultadoPautaEleitaDTO getPautasEleita(Integer id) {
        log.debug("Buscar os resutados da pauta eleita {}", id);
        Pauta pauta = findByIdPauta(id);
        return getResultadosPautaEleita(pauta);

    }

    private ResultadoPautaEleitaDTO getResultadosPautaEleita(Pauta pauta) {
        ResultadoPautaEleitaDTO resultadoPautaEleitaDTO = new ResultadoPautaEleitaDTO();
        Long votosFavoraveis = getNumeroVotosFavoraveis(pauta);
        Long votosContra = getNumeroVotosContra(pauta);
        resultadoPautaEleitaDTO.setPautaDTO(new PautaDTO(pauta));
        resultadoPautaEleitaDTO.setVotosFavoraveis(votosFavoraveis);
        resultadoPautaEleitaDTO.setVotosContras(votosContra);
        resultadoPautaEleitaDTO.setEleita(isEleita(votosFavoraveis, votosContra));
        return resultadoPautaEleitaDTO;
    }

    private Boolean isEleita(Long votosFavoraveis, Long votosContra) {
        return votosFavoraveis > votosContra;
    }

    private Long getNumeroVotosFavoraveis(Pauta pauta) {
        return pauta.getVotacoes().stream().filter(votacao -> Boolean.TRUE.equals(votacao.getVoto())).count();
    }

    private Long getNumeroVotosContra(Pauta pauta) {
        return pauta.getVotacoes().stream().filter(votacao -> Boolean.FALSE.equals(votacao.getVoto())).count();
    }
}
