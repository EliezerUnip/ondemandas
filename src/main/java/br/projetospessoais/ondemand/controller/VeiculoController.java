package br.projetospessoais.ondemand.controller;

import br.projetospessoais.ondemand.model.Veiculo;
import br.projetospessoais.ondemand.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<Veiculo> criar(@RequestBody Veiculo veiculo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(veiculo));
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

}

