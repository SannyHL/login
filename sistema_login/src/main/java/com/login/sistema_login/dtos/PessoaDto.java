package com.login.sistema_login.dtos;

import javax.validation.constraints.NotBlank;

public class PessoaDto {

    @NotBlank
    private Long cpf;
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;
    @NotBlank
    private String confirmaSenha;
    
}
