package com.example.springbootapi.service;

import com.example.springbootapi.abstracts.BaseRepository;
import com.example.springbootapi.abstracts.BaseService;
import com.example.springbootapi.domain.Pessoa;
import com.example.springbootapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService extends BaseService<Pessoa> {

    private PessoaRepository pessoaRepository;

    //@Override
    public BaseRepository<Pessoa> getRepository(){
        return pessoaRepository;
    }


    @Autowired
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public ResponseEntity<Pessoa> FazerAniversario(Long id){
        Optional<Pessoa> entry = getRepository().findById(id);
        if(entry.isPresent()) {
            Pessoa pessoa = entry.get();
            pessoa.setIdade(pessoa.getIdade() + 1);
            getRepository().save(pessoa);
            return new ResponseEntity<Pessoa>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
