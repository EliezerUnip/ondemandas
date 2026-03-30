package br.projetospessoais.ondemand.service;

import br.projetospessoais.ondemand.dto.DemandasDto;
import br.projetospessoais.ondemand.model.Demandas;
import br.projetospessoais.ondemand.repository.DemandasRepository;

public class DemandasService {

   private final DemandasRepository demandasRepository;

   public DemandasService(DemandasRepository demandasRepository) {
       this.demandasRepository = demandasRepository;
   }

   public Demandas criarDemandas(DemandasDto dto) {

       Demandas demandas = new Demandas();

       demandas.setTipo(dto.getTipoDemanda());
       demandas.setDescricao(dto.getDescricao());

       return demandasRepository.save(demandas);
   }


}
