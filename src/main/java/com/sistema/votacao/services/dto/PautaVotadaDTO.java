package com.sistema.votacao.services.dto;

import com.sistema.votacao.domain.Votacao;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class PautaVotadaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private List<Votacao> votacoes = new ArrayList<>();
}
