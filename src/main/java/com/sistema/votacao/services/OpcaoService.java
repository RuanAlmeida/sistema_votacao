package com.sistema.votacao.services;

import com.sistema.votacao.domain.Opcao;

import java.util.List;

public interface OpcaoService {

    List<Opcao> findAllOpcao();
}
