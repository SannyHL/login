package com.login.sistema_login.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.login.sistema_login.dtos.PessoaDto;
import com.login.sistema_login.models.PessoaModel;
import com.login.sistema_login.services.PessoaService;


@Controller
@RequestMapping("/usuario")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/cadastrar")
    public String cadastrar(){
        return "usuarios";
    }

    @PostMapping("/cadastrar")
    public String cadastro(@Valid PessoaDto pessoaDto){
        var pessoaModel = new PessoaModel();
        BeanUtils.copyProperties(pessoaDto, pessoaModel);
        if(pessoaModel.getSenha().equals(pessoaModel.getConfirmaSenha())){
            pessoaModel.setHorarioCadastro(LocalDateTime.now(ZoneId.of("UTC-3")));
            pessoaService.create(pessoaModel);
            return "login";
        } else {
            return "cadastro";
        }
        
    }

    @GetMapping("/")
    public ResponseEntity<List<PessoaModel>> getUsuarios(){
        return new ResponseEntity<>(pessoaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PessoaModel> buscarCpf(@PathVariable(value = "cpf") String cpf){
        Optional<PessoaModel> pessoaOptional = pessoaService.getCpf(cpf);
        if(pessoaOptional.isPresent()){
            return new ResponseEntity<>(pessoaOptional.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<PessoaModel> criarCadastro(@RequestBody @Valid PessoaDto pessoaDto){
        var pessoaModel = new PessoaModel();
        BeanUtils.copyProperties(pessoaDto, pessoaModel);
        pessoaModel.setHorarioCadastro(LocalDateTime.now(ZoneId.of("UTC-3")));
        
        return new ResponseEntity<>(pessoaService.create(pessoaModel), HttpStatus.CREATED);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<PessoaModel> atualizarCadastro(@PathVariable(value = "cpf") String cpf, @RequestBody @Valid PessoaDto pessoaDto){
        Optional<PessoaModel> pessoaOptional = pessoaService.getCpf(cpf);
        if(pessoaOptional.isPresent()){
            var pessoaModel = new PessoaModel();
            BeanUtils.copyProperties(pessoaDto, pessoaModel);
            pessoaModel.setHorarioCadastro(pessoaOptional.get().getHorarioCadastro());
            pessoaModel.setHorarioAtualizacaoCadastro(LocalDateTime.now(ZoneId.of("UTC-3")));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{cpf}")
    public ResponseEntity<PessoaModel> deleteUsuario(@PathVariable(value = "cpf") String cpf) {
        Optional<PessoaModel> pessoaOptional = pessoaService.getCpf(cpf);
        if (pessoaOptional.isPresent()){
            pessoaService.delete(pessoaOptional.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

}
