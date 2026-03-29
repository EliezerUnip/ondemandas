package br.projetospessoais.ondemand.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter

public class Rotas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn (name = "fk_demandas_id", nullable = false)
    private Demandas demanda;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_veiculo_id", nullable = false)
    private Veiculo veiculo;

    @Column(name = "km_inicial", nullable = false)
    private Integer kmInicial;

    @Column(name = "km_final", nullable = true)
    private Integer kmFinal;

    @Column(name = "descricao_rota", nullable = true)
    private String descricaoRota;

    @Column(name = "datahora_criacao", nullable = false, updatable = false)
    private LocalDateTime dataHoraCriacao;

}
