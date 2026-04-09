package br.projetospessoais.ondemand.service;

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

    public Usuario criar(Usuario usuario) {
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

        // ❌ não encontrou usuário
        if (usuario == null) {
            return false;
        }

        // ❌ usuário inativo
        if (usuario.getAtivo() == null || !usuario.getAtivo()) {
            return false;
        }

        // ❌ senha não cadastrada (usuários antigos)
        if (usuario.getSenha() == null) {
            return false;
        }

        // ✔ validação final
        return usuario.getSenha().equals(senha);
    }


}

