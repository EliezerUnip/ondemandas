package br.projetospessoais.ondemand.controller;

import br.projetospessoais.ondemand.model.Local;
import br.projetospessoais.ondemand.service.LocalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locais")
public class LocalController {

    private final LocalService service;

    public LocalController(LocalService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Local> criar(@RequestBody Local local) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(local));
    }

    @GetMapping
    public ResponseEntity<List<Local>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Local> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}
