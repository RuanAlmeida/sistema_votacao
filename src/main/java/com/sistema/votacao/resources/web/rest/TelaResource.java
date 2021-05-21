package com.sistema.votacao.resources.web.rest;

import com.sistema.votacao.domain.Tela;
import com.sistema.votacao.services.TelaService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/telas")
public class TelaResource {

    private final TelaService telaService;

    @ApiOperation(value="Busca por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Tela> findById(@PathVariable Integer id) {
        Tela tela = telaService.findByIdTela(id);
        return ResponseEntity.ok().body(tela);
    }

}
