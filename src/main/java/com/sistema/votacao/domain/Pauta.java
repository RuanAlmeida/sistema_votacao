package com.sistema.votacao.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Pauta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private Integer versao;
    private LocalDate dataCriacao;
    private Boolean votada;

    @OneToMany(mappedBy="pauta", cascade= CascadeType.ALL)
    private List<Votacao> votacoes = new ArrayList<>();
}
