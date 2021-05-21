package com.sistema.votacao.services.impl;

import com.sistema.votacao.domain.Tela;
import com.sistema.votacao.repositories.TelaRepository;
import com.sistema.votacao.services.TelaService;
import com.sistema.votacao.services.exception.ObjectNotFoundException;
import com.sistema.votacao.services.utils.MensagensUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TelaServiceImpl implements TelaService {

    private final Logger log = LoggerFactory.getLogger(TelaService.class);

    private final TelaRepository telaRepository;

    @Override
    public Tela findByIdTela(Integer id) {
        log.debug("Buscar pauta pelo id {}", id);
        return telaRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException(MensagensUtils.TELA_NAO_ENCONTRADA + id));
    }
}
