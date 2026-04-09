package br.projetospessoais.ondemand.controller;

import br.projetospessoais.ondemand.dto.TipoDto;
import br.projetospessoais.ondemand.model.TipoDemandas;
import br.projetospessoais.ondemand.service.TipoDemandasService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-demandas")
public class TipoController {

    private final TipoDemandasService service;

    public TipoController(TipoDemandasService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TipoDemandas> criar(@RequestBody @Valid TipoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<TipoDemandas>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDemandas> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDemandas> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid TipoDto dto) {

        return ResponseEntity.ok(service.atualizar(id, dto));
    }
}

