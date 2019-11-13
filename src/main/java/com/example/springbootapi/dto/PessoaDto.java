package com.example.springbootapi.dto;

import com.example.springbootapi.domain.Pessoa;
import lombok.Data;

@Data
public class PessoaDto {

    private String nome;
    private Integer idade;

    public PessoaDto(){}

    public PessoaDto(Pessoa pessoa){
        this.nome = pessoa.getNome();
        this.idade = pessoa.getIdade();
    }
}
