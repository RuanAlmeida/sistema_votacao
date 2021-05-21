package com.sistema.votacao.repositories;

import com.sistema.votacao.domain.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotacaoRepository extends JpaRepository<Votacao, Integer> {
}
