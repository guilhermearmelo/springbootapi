package com.example.springbootapi.dto;

import com.example.springbootapi.abstracts.BaseDto;
import com.example.springbootapi.domain.Pessoa;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PessoaDto extends BaseDto {

    private String nome;
    private Integer idade;

    public PessoaDto(){}

    public PessoaDto(Pessoa pessoa){
        this.nome = pessoa.getNome();
        this.idade = pessoa.getIdade();
    }
}
