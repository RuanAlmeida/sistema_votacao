package com.sistema.votacao.repositories;

import com.sistema.votacao.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepository extends JpaRepository<Pauta, Integer> {
}
