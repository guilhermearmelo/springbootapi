package com.example.springbootapi.abstracts;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

public abstract class BaseRestController <E extends BaseEntity, D extends BaseDto>{

    protected abstract BaseService<E, D> getService();

    //GET ALL
    @RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public List<D> Get() {
        List<E> result = getService().BuscarTodos();
        return parseToDto(result);
    }

    // POST
    @RequestMapping(value = "/pessoa", method =  RequestMethod.POST)
    public D Post(@Valid @RequestBody E entity) {
        E result = getService().Inserir(entity);
        return parseToDto(result);
    }

    // POST LIST
    @RequestMapping(value = "/pessoalist", method = RequestMethod.POST)
    public ResponseEntity<List<D>> PostList(@Valid @RequestBody List <E> list){
        ResponseEntity<List<E>> response = getService().InserirLista(list);
        List<D> listDto = parseToDto(response.getBody());
        HttpStatus status = response.getStatusCode();
        return new ResponseEntity<List<D>>(listDto,status);
    }

    // GET BY ID
    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.GET)
    public ResponseEntity<D> GetById(@PathVariable(value = "id") long id) {
        ResponseEntity<E> entity = getService().BuscarPorId(id);
        if(entity.getStatusCode() == HttpStatus.OK){
            D dto = parseToDto(entity);
            return new ResponseEntity<D>(parseToDto(entity), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    // PUT
    @RequestMapping(value = "/pessoa/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<E> Put(@PathVariable(value = "id") long id, @Valid @RequestBody E entity) {
        return getService().AtualizarPorId(id, entity);
    }

    // DELETE BY ID
    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        return  getService().ApagarPorId(id);
    }

    // DELETE ALL
    @RequestMapping(value = "/pessoa", method = RequestMethod.DELETE)
    public ResponseEntity<Object> DeleteAll(){
        return getService().ApagarTodos();
    }



    protected abstract List<D> parseToDto(List<E> list);
    protected abstract D parseToDto(E entity);
    protected abstract D parseToDto(ResponseEntity<E> entity);

}
