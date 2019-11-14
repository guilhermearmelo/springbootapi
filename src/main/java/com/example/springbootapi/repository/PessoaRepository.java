package com.example.springbootapi.repository;

import com.example.springbootapi.abstracts.BaseRepository;
import com.example.springbootapi.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends BaseRepository<Pessoa> {

}