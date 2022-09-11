package com.login.sistema_login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.sistema_login.models.PessoaModel;
import com.login.sistema_login.repositories.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaModel create(PessoaModel pessoaModel) {
        return pessoaRepository.save(pessoaModel);
    }
    

}
