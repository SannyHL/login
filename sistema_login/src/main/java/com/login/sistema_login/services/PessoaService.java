package com.login.sistema_login.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.sistema_login.models.PessoaModel;
import com.login.sistema_login.repositories.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public PessoaModel create(PessoaModel pessoaModel) {
        return pessoaRepository.save(pessoaModel);
    }
    
    public List<PessoaModel> findAll(){
        return pessoaRepository.findAll();
    }

    public Optional<PessoaModel> getCpf(String cpf) {
        return pessoaRepository.findById(cpf);
    }

    @Transactional
    public void delete(PessoaModel pessoaModel) {
        pessoaRepository.delete(pessoaModel);
    }

}
