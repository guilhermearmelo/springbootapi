package com.example.springbootapi.abstracts;

public abstract class BaseService <E extends BaseEntity>{

    public abstract BaseRepository<E> getRepository();

}
