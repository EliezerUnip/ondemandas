package br.projetospessoais.ondemand.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "modelo_veiculo", nullable = false)
    private String modeloVeiculo;

    @Column(name = "placa_veiculo", nullable = false)
    private String placaVeiculo;

    @Column(name = "ano_veiculo", nullable = false)
    private Integer anoVeiculo;

    @Column(name = "km_atual", nullable = false)
    private Integer kmAtual;

    @Column(name = "status_veiculo", nullable = false)
    private String statusVeiculo;

    @Column(name = "quantidade_lugares", nullable = false)
    private Integer quantidadeLugares;
}
