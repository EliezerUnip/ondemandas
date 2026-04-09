package br.projetospessoais.ondemand.service;

import br.projetospessoais.ondemand.model.Veiculo;
import br.projetospessoais.ondemand.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Veiculo criar(Veiculo veiculo) {
        return repository.save(veiculo);
    }

    public List<Veiculo> listar() {
        return repository.findAll();
    }

    public Veiculo buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
    }
}

