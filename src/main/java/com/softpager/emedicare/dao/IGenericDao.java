package com.softpager.emedicare.dao;

import com.softpager.emedicare.entities.Doctor;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IGenericDao<T extends Serializable> {

    Object addNew(Object t);
    Object update(T t);
    List<T> getAll();
    Optional<T> getOne(long theId);
    void delete(long theId);
    long countAll();
    void setClazz(Class<T> clazz);
}
