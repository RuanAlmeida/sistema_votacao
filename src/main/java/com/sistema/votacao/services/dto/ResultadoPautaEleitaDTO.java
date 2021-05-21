package com.sistema.votacao.services.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultadoPautaEleitaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private PautaDTO pautaDTO;
    private Long votosFavoraveis;
    private Long votosContras;
    private Boolean eleita;
}
