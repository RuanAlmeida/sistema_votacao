package com.sistema.votacao.services.impl;

import com.sistema.votacao.domain.Opcao;
import com.sistema.votacao.repositories.OpcaoRepository;
import com.sistema.votacao.services.OpcaoService;
import com.sistema.votacao.services.PautaService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OpcaoServiceImpl implements OpcaoService {

    private final Logger log = LoggerFactory.getLogger(PautaService.class);

    private final OpcaoRepository opcaoRepository;

    @Override
    public List<Opcao> findAllOpcao() {
        log.debug("Buscar todas as opcoes");
        return opcaoRepository.findAll();
    }
}
