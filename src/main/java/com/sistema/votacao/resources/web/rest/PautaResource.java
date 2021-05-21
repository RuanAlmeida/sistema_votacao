package com.sistema.votacao.resources.web.rest;

import com.sistema.votacao.domain.Pauta;
import com.sistema.votacao.services.PautaService;
import com.sistema.votacao.services.dto.PautaDTO;
import com.sistema.votacao.services.dto.PautaVotadaDTO;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/pautas")
public class PautaResource {

    private final PautaService pautaService;

    @ApiOperation(value="Busca por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Pauta> findById(@PathVariable Integer id) {
        Pauta pauta = pautaService.findByIdPauta(id);
        return ResponseEntity.ok().body(pauta);
    }

    @ApiOperation(value="Salva uma nova pauta.")
    @PostMapping(value = "/save")
    public ResponseEntity<Void> findByTitle(@RequestBody PautaDTO pautaDTO) {
        pautaService.savePauta(pautaDTO);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value="Atualiza uma pauta.")
    @PutMapping(value = "/update")
    public ResponseEntity<Void> findByTitle(@RequestBody PautaVotadaDTO pautaVotadaDTO) {
        pautaService.updatePauta(pautaVotadaDTO);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value="Paginacao.")
    @GetMapping()
    public ResponseEntity<Page<PautaDTO>> findpage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage) {
        Page<Pauta> pautas = pautaService.findPagePauta(page, linesPerPage);
        Page<PautaDTO> pautaDTOs = pautas.map(PautaDTO::new);
        return ResponseEntity.ok().body(pautaDTOs);
    }
}
