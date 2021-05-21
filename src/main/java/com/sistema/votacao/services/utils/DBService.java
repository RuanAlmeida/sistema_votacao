package com.sistema.votacao.services.utils;

import com.sistema.votacao.domain.Botao;
import com.sistema.votacao.domain.ItemOpcao;
import com.sistema.votacao.domain.ItemTela;
import com.sistema.votacao.domain.Opcao;
import com.sistema.votacao.domain.Tela;
import com.sistema.votacao.repositories.OpcaoRepository;
import com.sistema.votacao.repositories.TelaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Arrays;


@Transactional
@RequiredArgsConstructor
@Service
public class DBService {

    private final OpcaoRepository opcaoRepository;

    private final TelaRepository telaRepository;

    public void instantiateTestDatabase() throws ParseException {
//        saveTela();
//        saveOpcao();
    }

    private void saveOpcao() {
        Opcao opcao = new Opcao();
        setOpcao(opcao);
        addItensOpcao(opcao);
        opcaoRepository.save(opcao);
    }

    private void setOpcao(Opcao opcao) {
        opcao.setTipo("Selecao");
        opcao.setTitulo("Lista de Selecao");
    }

    private void addItensOpcao(Opcao opcao) {
        ItemOpcao itemOpcao1 = new ItemOpcao(null, "Formulario Pautas", "/", opcao);
        ItemOpcao itemOpcao2 = new ItemOpcao(null, "Votar Pauta", "/", opcao);
        ItemOpcao itemOpcao3 = new ItemOpcao(null, "Pauta Eleita", "/", opcao);
        opcao.getItens().addAll(Arrays.asList(itemOpcao1, itemOpcao2, itemOpcao3));
    }

    private void saveTela() {
        Tela tela = new Tela();
        setTela(tela);
        addItensTela(tela);
        addBotoesTela(tela);
        telaRepository.save(tela);
    }

    private void setTela(Tela tela) {
        tela.setTipo("Formulario");
        tela.setTitulo("Formulario Pauta");
    }

    private void addBotoesTela(Tela tela) {
        Botao botao1 = new Botao(null, "cancelar", "/", tela);
        Botao botao2 = new Botao(null, "salvar", "/", tela);
        tela.getBotoesDTO().addAll(Arrays.asList(botao1, botao2));
    }

    private void addItensTela(Tela tela) {
        ItemTela itemTela1 = new ItemTela(null, "text", "descricao", tela);
        ItemTela itemTela2 = new ItemTela(null, "Data", "criacao", tela);
        tela.getItens().addAll(Arrays.asList(itemTela1, itemTela2));
    }

    @Bean
    public void instantiateDatabase() throws ParseException {
        instantiateTestDatabase();
    }
}
