package br.projetospessoais.ondemand.service;

import br.projetospessoais.ondemand.dto.VeiculoDto;
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

    public Veiculo criar(VeiculoDto dto) {
        Veiculo veiculo = new Veiculo();
        veiculo.setMarcaVeiculo(dto.getMarcaVeiculo());
        veiculo.setModeloVeiculo(dto.getModeloVeiculo());
        veiculo.setPlacaVeiculo(dto.getPlacaVeiculo());
        veiculo.setAnoVeiculo(dto.getAnoVeiculo());
        veiculo.setKmAtual(dto.getKmAtual());
        veiculo.setStatusVeiculo(dto.getStatusVeiculo());
        veiculo.setQuantidadeLugares(dto.getQuantidadeLugares());

        return repository.save(veiculo);
    }

    public List<Veiculo> listar() {
        return repository.findAll();
    }

    public Veiculo buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
    }

    public Veiculo atualizar(Long id, VeiculoDto dto) {
        Veiculo veiculo = buscarPorId(id);

        veiculo.setMarcaVeiculo(dto.getMarcaVeiculo());
        veiculo.setModeloVeiculo(dto.getModeloVeiculo());
        veiculo.setPlacaVeiculo(dto.getPlacaVeiculo());
        veiculo.setAnoVeiculo(dto.getAnoVeiculo());
        veiculo.setKmAtual(dto.getKmAtual());
        veiculo.setStatusVeiculo(dto.getStatusVeiculo());
        veiculo.setQuantidadeLugares(dto.getQuantidadeLugares());

        return repository.save(veiculo);
    }
}

