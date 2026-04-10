package br.projetospessoais.ondemand.controller;

import br.projetospessoais.ondemand.model.Usuario;
import br.projetospessoais.ondemand.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {

        if (usuario.getAtribuicao() == null) {
            throw new RuntimeException("Atribuição obrigatória");
        }

        usuario.setAtivo(true);
        usuario.setSenha("123");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}