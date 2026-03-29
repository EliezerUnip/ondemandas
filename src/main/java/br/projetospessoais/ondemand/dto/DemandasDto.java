package br.projetospessoais.ondemand.dto;

import br.projetospessoais.ondemand.model.TipoDemandas;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DemandasDto {

    @NotBlank
    private TipoDemandas tipoDemanda;

    @NotBlank
    private String descricao;

}
