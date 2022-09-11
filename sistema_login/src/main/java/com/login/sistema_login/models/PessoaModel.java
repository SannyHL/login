package com.login.sistema_login.models;

import javax.persistence.*;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @CPF
    private String cpf;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    @Email
    private String email;
    @Column(nullable = false)
    private String senha;
    @Column (nullable = false)
    private String confirmaSenha;

    
    
}
