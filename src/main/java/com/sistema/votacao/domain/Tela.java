package com.sistema.votacao.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Tela implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String tipo;
    private String titulo;

    @OneToMany(mappedBy="tela", cascade= CascadeType.ALL)
    private List<ItemTela> itens = new ArrayList<>();

    @OneToMany(mappedBy="tela", cascade= CascadeType.ALL)
    private List<Botao> botoesDTO = new ArrayList<>();

}
