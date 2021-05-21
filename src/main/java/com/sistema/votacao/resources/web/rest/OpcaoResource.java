package com.sistema.votacao.resources.web.rest;

import com.sistema.votacao.domain.Opcao;
import com.sistema.votacao.services.OpcaoService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/opcoes")
public class OpcaoResource {

    private final OpcaoService opcaoService;

    @ApiOperation(value="Busca todas as opcoes")
    @GetMapping()
    public ResponseEntity<List<Opcao>> findById() {
        List<Opcao> opcoes = opcaoService.findAllOpcao();
        return ResponseEntity.ok().body(opcoes);
    }

}
