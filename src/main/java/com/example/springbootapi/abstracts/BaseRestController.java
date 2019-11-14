package com.example.springbootapi.abstracts;

public abstract class BaseRestController <E extends BaseEntity>{

    protected abstract BaseService<E> getService();

}
