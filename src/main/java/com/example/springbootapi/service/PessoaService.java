package com.example.springbootapi.service;

import com.example.springbootapi.domain.Pessoa;
import com.example.springbootapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa aniversario(Pessoa pessoa){
        pessoa.setIdade(pessoa.getIdade()+1);
        return pessoaRepository.save(pessoa);
    }
}
