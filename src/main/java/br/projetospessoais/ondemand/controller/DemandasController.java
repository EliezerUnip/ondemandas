package br.projetospessoais.ondemand.controller;


import br.projetospessoais.ondemand.dto.DemandasDto;
import br.projetospessoais.ondemand.model.Demandas;
import br.projetospessoais.ondemand.service.DemandasService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demandas")
public class DemandasController {

    private final DemandasService demandasService;

    public DemandasController(DemandasService demandasService) {
        this.demandasService = demandasService;
    }

    @PostMapping
    public ResponseEntity<Demandas> criar(@RequestBody @Valid DemandasDto dto) {

        Long usuarioId = 1L;

        Demandas demanda = demandasService.criarDemanda(dto, usuarioId);

        return ResponseEntity.status(HttpStatus.CREATED).body(demanda);
    }


    @GetMapping
    public ResponseEntity<List<Demandas>> listar() {
        return ResponseEntity.ok(demandasService.listar());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Demandas> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(demandasService.buscarPorId(id));
    }
}
