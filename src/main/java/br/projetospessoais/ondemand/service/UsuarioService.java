package br.projetospessoais.ondemand.service;

import br.projetospessoais.ondemand.dto.UsuarioDto;
import br.projetospessoais.ondemand.model.Usuario;
import br.projetospessoais.ondemand.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario criar(UsuarioDto dto) {
        Usuario usuario = new Usuario();

        usuario.setNome(dto.getNome().trim());
        usuario.setEmail(dto.getEmail().trim());
        usuario.setTelefone(dto.getTelefone().trim());
        usuario.setAtribuicao(dto.getAtribuicao());
        usuario.setAtivo(true);
        usuario.setSenha("123");

        return repository.save(usuario);
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public boolean validarLogin(String email, String senha) {
        Usuario usuario = repository.findByEmail(email);

        if (usuario == null) {
            return false;
        }

        if (usuario.getAtivo() == null || !usuario.getAtivo()) {
            return false;
        }

        if (usuario.getSenha() == null) {
            return false;
        }

        return usuario.getSenha().equals(senha);
    }
}