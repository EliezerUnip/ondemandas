package br.projetospessoais.ondemand.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "demandas")
@Getter
@Setter

public class Demandas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_tipo_demanda_id", nullable = false)
    private TipoDemandas tipo;

    @Column(name = "data_hora_criacao", nullable = false, updatable = false)
    private LocalDateTime dataHoraCriacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_descricao_local_id", nullable = false)
    private Local local;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_solicitante_id", nullable = false)
    private Usuario solicitante;

    @Column(name = "descricao_demanda", nullable = false, length = 255)
    private String descricao;

    @ManyToOne(optional = true)
    @JoinColumn(name = "fk_executor_id", nullable = true)
    private Usuario executor;

    @Column(name = "data_hora_conclusao")
    private LocalDateTime dataHoraConclusao;

    @Enumerated(EnumType.STRING)
    private StatusDemanda status;

    public enum StatusDemanda {
        PENDENTE,
        CONCLUIDA,
        INATIVADA
    }

    @Column(name = "nome_receptor")
    private String nomeReceptor;

}
