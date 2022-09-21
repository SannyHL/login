package com.login.sistema_login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.login.sistema_login.models.LoginModel;
import com.login.sistema_login.models.PessoaModel;
import com.login.sistema_login.services.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String paglogin(){
        return "login";
    }
    
    @PostMapping("/")
    public String logar(LoginModel loginModel, PessoaModel pessoaModel){
        PessoaModel pessoa = loginService.fazerLogin(pessoaModel.getEmailUsuario(), pessoaModel.getSenha());
        if(pessoa != null){
            return "usuarios";
        }
        return "login";
    }
}
