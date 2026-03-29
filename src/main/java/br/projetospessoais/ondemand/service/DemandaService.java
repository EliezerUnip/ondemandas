package br.projetospessoais.ondemand.service;

import br.projetospessoais.ondemand.dto.DemandasDto;
import br.projetospessoais.ondemand.model.Demandas;
import br.projetospessoais.ondemand.repository.DemandasRepository;

public class DemandaService {

   private final DemandasRepository demandasRepository;

   public DemandaService(DemandasRepository demandasRepository) {
       this.demandasRepository = demandasRepository;
   }

   public Demandas criarDemandas(DemandasDto dto) {

       Demandas demandas = new Demandas();

       demandas.setTipoDemanda(dto.getTipoDemanda());
       demandas.setDescricaoDemanda(dto.getDescricao());

       return demandasRepository.save(demandas);
   }


}
