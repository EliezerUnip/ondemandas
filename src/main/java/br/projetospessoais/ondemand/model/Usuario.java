package br.projetospessoais.ondemand.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    @Enumerated(EnumType.STRING)
    private Atribuicao atribuicao;

    private String telefone;
    private Boolean ativo = true;
    private String senha;

    public enum Atribuicao {
        SOLICITANTE,
        EXECUTOR,
        ADMINISTRADOR
    }
}
