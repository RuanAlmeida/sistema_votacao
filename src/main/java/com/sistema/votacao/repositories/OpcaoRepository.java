package com.sistema.votacao.repositories;

import com.sistema.votacao.domain.Opcao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpcaoRepository extends JpaRepository<Opcao, Integer> {
}
