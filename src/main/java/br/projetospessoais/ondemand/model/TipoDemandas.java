package br.projetospessoais.ondemand.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class TipoDemandas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String tipoDemanda;

    @Column(nullable = false)
    private Boolean ativo = true;
}
