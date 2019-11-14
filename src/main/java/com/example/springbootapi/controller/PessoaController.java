package com.example.springbootapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.springbootapi.abstracts.BaseRestController;
import com.example.springbootapi.abstracts.BaseService;
import com.example.springbootapi.domain.Pessoa;
import com.example.springbootapi.dto.PessoaDto;
import com.example.springbootapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PessoaController extends BaseRestController<Pessoa, PessoaDto> {

    @Autowired
    private PessoaService pessoaService;

    @Override
    protected BaseService<Pessoa, PessoaDto> getService(){
        return pessoaService;
    }

    @Override
    protected List<PessoaDto> parseToDto(List<Pessoa> list){
        return list.stream().map(PessoaDto::new).collect(Collectors.toList());
    }

    @Override
    protected PessoaDto parseToDto(Pessoa entity){
        return new PessoaDto(entity);
    }

    @Override
    protected PessoaDto parseToDto(ResponseEntity<Pessoa> entity){
        Pessoa pessoa = entity.getBody();
        return new PessoaDto(pessoa);
    }

    // PUT (ANIVERSARIO)
    @RequestMapping(value = "/pessoa_aniversario/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pessoa> Aniversario(@PathVariable(value = "id") long id){
        return pessoaService.FazerAniversario(id);
    }
}