package com.sistema.votacao.services;

import com.sistema.votacao.domain.Pauta;
import com.sistema.votacao.services.dto.PautaDTO;
import com.sistema.votacao.services.dto.PautaVotadaDTO;
import com.sistema.votacao.services.dto.ResultadoPautaEleitaDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PautaService {

    void savePauta(PautaDTO pautaDTO);

    void updatePauta(PautaVotadaDTO pautaVotadaDTO);

    Pauta findByIdPauta(Integer id);

    Page<Pauta> findPagePauta(Integer page, Integer linesPerPage);

    List<PautaDTO> findAllPautas();

    ResultadoPautaEleitaDTO getPautasEleita(Integer id);

}
