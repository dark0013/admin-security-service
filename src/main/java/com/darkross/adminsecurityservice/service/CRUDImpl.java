package com.darkross.adminsecurityservice.service;

import com.darkross.adminsecurityservice.exception.ModelNotFoundException;
import com.darkross.adminsecurityservice.repository.IGenericRepo;
import com.darkross.adminsecurityservice.service.interfaces.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND" + id));
        return getRepo().save(t);
    }

    @Override
    public void delete(ID id) {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND" + id));
        getRepo().deleteById(id);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public T findbyId(ID id) {
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND" + id));
    }

}
