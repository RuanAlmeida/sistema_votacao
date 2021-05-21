package com.sistema.votacao.services.dto;

import com.sistema.votacao.domain.Pauta;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class PautaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String descricao;
    private Integer versao;
    private LocalDate dataCriacao;
    private Boolean votada;

    public PautaDTO(Pauta pauta) {
        descricao = pauta.getDescricao();
        versao = pauta.getVersao();
        dataCriacao = pauta.getDataCriacao();
        votada = pauta.getVotada();
    }
}
