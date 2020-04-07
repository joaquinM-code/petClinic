package com.ecatom.sfpetclinic.services;

import java.util.Set;

//Common methods interface
public interface CrudService<T, ID> {
    Set<T> findAll();
    T findById(ID id);
    T save(T object);
    void delete(T object);
    void deleteById(ID id);
}
