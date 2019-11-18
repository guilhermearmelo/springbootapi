package com.example.springbootapi.abstracts;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public abstract class BaseService <E extends BaseEntity, D extends BaseDto>{

    public abstract BaseRepository<E> getRepository();

    public List<E> BuscarTodos(){
        return getRepository().findAll();
    }

    public E Inserir(E entity){
        return getRepository().save(entity);
    }

    public ResponseEntity<E> BuscarPorId(long id){
        Optional<E> entity = getRepository().findById(id);
        if(entity.isPresent())
            return new ResponseEntity<E>(entity.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<E> AtualizarPorId(long id, E entity){
        Optional<E> entry = getRepository().findById(id);
        if(entry.isPresent()) {
            getRepository().deleteById(id);
            entity.setId(id);
            getRepository().save(entity);
            return new ResponseEntity<E>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> ApagarPorId(long id){
        Optional<E> entry = getRepository().findById(id);
        if(entry.isPresent()){
            getRepository().deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> ApagarTodos(){
        if(getRepository().count() > 0){
            getRepository().deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    public abstract E parseDtoToEntity(D dto);
}
