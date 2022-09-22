package com.login.sistema_login.models;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class PessoaModel {

    @Id
    @CPF
    private String cpf;
    private String nome;
    @Email
    private String emailUsuario;
    private String senha;
    private String confirmaSenha;
    private LocalDateTime horarioCadastro;
    private LocalDateTime horarioAtualizacaoCadastro;

    
    
}
