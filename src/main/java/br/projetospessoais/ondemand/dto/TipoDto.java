package br.projetospessoais.ondemand.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoDto {

    @NotBlank
    private String tipoDemandaDescricao;

    @NotNull
    private Boolean ativo;
}
