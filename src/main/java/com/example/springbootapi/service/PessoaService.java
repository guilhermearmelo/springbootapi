package com.example.springbootapi.service;

import com.example.springbootapi.domain.Pessoa;
import com.example.springbootapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> BuscarTodos() {
        return pessoaRepository.findAll();
    }

    public Pessoa Inserir(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public ResponseEntity<Pessoa> BuscarPorId(Long id){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if(pessoa.isPresent())
            return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Pessoa> FazerAniversario(Long id){
        Optional<Pessoa> entry = pessoaRepository.findById(id);
        if(entry.isPresent()) {
            Pessoa pessoa = entry.get();
            pessoa.setIdade(pessoa.getIdade() + 1);
            pessoaRepository.save(pessoa);
            return new ResponseEntity<Pessoa>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Pessoa> AtualizarPorId(Long id, Pessoa newPessoa){
        Optional<Pessoa> entry = pessoaRepository.findById(id);
        if(entry.isPresent()) {
            Pessoa toUpdate = entry.get();
            toUpdate.setNome(newPessoa.getNome());
            toUpdate.setIdade(newPessoa.getIdade());
            pessoaRepository.save(toUpdate);
            return new ResponseEntity<Pessoa>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity ApagarPorId(Long id){
        Optional<Pessoa> entry = pessoaRepository.findById(id);
        if(entry.isPresent()){
            pessoaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
