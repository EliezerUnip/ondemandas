package br.projetospessoais.ondemand.service;

import br.projetospessoais.ondemand.model.Local;
import br.projetospessoais.ondemand.repository.LocalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalService {

    private final LocalRepository repository;

    public LocalService(LocalRepository repository) {
        this.repository = repository;
    }

    public Local criar(Local dto) {
        return repository.save(dto);
    }

    public List<Local> listar() {
        return repository.findAll();
    }

    public Local buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Local não encontrado"));
    }
}

