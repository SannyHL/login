package com.login.sistema_login.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.login.sistema_login.dtos.PessoaDto;
import com.login.sistema_login.models.PessoaModel;
import com.login.sistema_login.services.PessoaService;


@Controller
@RequestMapping(value = "/usuario")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/cadastrar")
    public String cadastrar(){
        return "usuarios";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<PessoaModel> cadastro(PessoaDto pessoaDto){
        var pessoaModel = new PessoaModel();
        BeanUtils.copyProperties(pessoaDto, pessoaModel);
        pessoaModel.setHorarioCadastro(LocalDateTime.now(ZoneId.of("UTC-3")));
        return new ResponseEntity<>(pessoaService.create(pessoaModel), HttpStatus.CREATED);
    }
}
