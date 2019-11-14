package com.example.springbootapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.springbootapi.domain.Pessoa;
import com.example.springbootapi.repository.PessoaRepository;
import com.example.springbootapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    // GET
    @RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public List<Pessoa> Get() {
        return pessoaService.BuscarTodos();
    }

    // POST
    @RequestMapping(value = "/pessoa", method =  RequestMethod.POST)
    public Pessoa Post(@Valid @RequestBody Pessoa pessoa) {
        return pessoaService.Inserir(pessoa);
    }

    // GET BY ID
    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> GetById(@PathVariable(value = "id") long id) {
        return pessoaService.BuscarPorId(id);
    }

    // PUT (ANIVERSARIO)
    @RequestMapping(value = "/pessoa_aniversario/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pessoa> Aniversario(@PathVariable(value = "id") long id){
        return pessoaService.FazerAniversario(id);
    }

    // PUT
    @RequestMapping(value = "/pessoa/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Pessoa> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Pessoa newPessoa) {
        return pessoaService.AtualizarPorId(id, newPessoa);
    }

    // DELETE BY ID
    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        return  pessoaService.ApagarPorId(id);
    }
}