package com.login.sistema_login.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class PessoaDto {

    @NotBlank
    private String cpf;
    @NotBlank
    private String nome;
    @NotBlank
    private String emailUsuario;
    @NotBlank
    private String senha;
    @NotBlank
    private String confirmaSenha;
    
}
