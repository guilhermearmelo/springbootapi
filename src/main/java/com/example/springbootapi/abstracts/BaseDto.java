package com.example.springbootapi.abstracts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseDto implements Serializable {
    protected Long id;
    protected String nome;

    public BaseDto(BaseEntity entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

    public BaseDto() {
    }
}
