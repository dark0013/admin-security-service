package com.darkross.adminsecurityservice.service.interfaces;

import java.util.List;

public interface ICRUD<T, ID> {

    T save(T t);

    T update(T t, ID id);

    void delete(ID id);

    List<T> findAll();

    T findbyId(ID id);
}
