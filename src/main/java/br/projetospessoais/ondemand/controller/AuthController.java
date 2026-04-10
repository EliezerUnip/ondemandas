package br.projetospessoais.ondemand.controller;

import br.projetospessoais.ondemand.dto.LoginDto;
import br.projetospessoais.ondemand.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto dto) {

        boolean valido = usuarioService.validarLogin(
                dto.getEmail(),
                dto.getSenha()
        );

        if (valido) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(401).build();
        }
    }
}

