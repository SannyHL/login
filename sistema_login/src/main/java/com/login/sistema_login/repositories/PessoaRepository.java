package com.login.sistema_login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.login.sistema_login.models.PessoaModel;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, String>{
    
    @Query(value="select * from usuarios where emailUsuario = :emailUsuario and senha = :senha", nativeQuery=true)
    public PessoaModel Login(String emailUsuario, String senha);
    
}
