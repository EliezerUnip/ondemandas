package br.projetospessoais.ondemand.service;


import br.projetospessoais.ondemand.dto.TipoDto;
import br.projetospessoais.ondemand.model.TipoDemandas;
import br.projetospessoais.ondemand.repository.TiposDemandasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDemandasService {

    private final TiposDemandasRepository repository;

    public TipoDemandasService(TiposDemandasRepository repository) {
        this.repository = repository;
    }

    public TipoDemandas criar(TipoDto dto) {

        TipoDemandas tipo = new TipoDemandas();
        tipo.setTipoDemanda(dto.getTipoDemandaDescricao());
        tipo.setAtivo(dto.getAtivo());

        return repository.save(tipo);
    }

    public List<TipoDemandas> listar() {
        return repository.findAll();
    }

    public TipoDemandas buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo não encontrado"));
    }

    public TipoDemandas atualizar(Long id, TipoDto dto) {

        TipoDemandas tipo = buscarPorId(id);

        tipo.setTipoDemanda(dto.getTipoDemandaDescricao());
        tipo.setAtivo(dto.getAtivo());

        return repository.save(tipo);
    }
}