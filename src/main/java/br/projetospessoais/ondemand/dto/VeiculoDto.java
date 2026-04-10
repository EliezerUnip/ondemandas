package br.projetospessoais.ondemand.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class VeiculoDto {


    @NotBlank
    private String marcaVeiculo;

    @NotBlank
    private String modeloVeiculo;

    @NotBlank
    private String placaVeiculo;

    @NotNull
    private Integer anoVeiculo;

    @NotNull
    private Integer kmAtual;

    @NotNull
    private Boolean statusVeiculo;

    @NotNull
    private Integer quantidadeLugares;


}

