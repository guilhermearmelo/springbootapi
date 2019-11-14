package com.example.springbootapi.abstracts;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    public abstract Long getId();
    public abstract void setId(Long id);

    @Column
    private String nome;
}
