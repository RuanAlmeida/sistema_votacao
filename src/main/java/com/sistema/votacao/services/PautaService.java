package com.sistema.votacao.services;

import com.sistema.votacao.domain.Pauta;
import com.sistema.votacao.services.dto.PautaDTO;
import com.sistema.votacao.services.dto.PautaVotadaDTO;
import org.springframework.data.domain.Page;

public interface PautaService {

    void savePauta(PautaDTO pautaDTO);

    void updatePauta(PautaVotadaDTO pautaVotadaDTO);

    Pauta findByIdPauta(Integer id);

    Page<Pauta> findPagePauta(Integer page, Integer linesPerPage);

}
