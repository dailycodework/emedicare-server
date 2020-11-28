package com.softpager.emedicare.dao;

import com.softpager.emedicare.entities.Doctor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public class GenericDao<T extends Serializable> implements IGenericDao<T> {

    private Class<T> clazz;
    private final SessionFactory sessionFactory;

    @Autowired
    public GenericDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object addNew(Object t) {
        return  currentSession().save(t);
    }

    @Override
    public Object update(T t) {
        return  currentSession().merge(t);
    }

    @Override
    public List<T> getAll() {
        return currentSession().createQuery("from " +clazz.getName()).list();
    }

    @Override
    public Optional<T> getOne(long theId) {
        return Optional.ofNullable((T) currentSession().get(clazz, theId));
    }

    @Override
    public void delete(long theId) {
        currentSession().delete(theId);
    }

    @Override
    public long countAll() {
        List<T> all = getAll();
        return all.size();
    }

   /* protected Session currentSession(){
        return sessionFactory.getCurrentSession();
    }*/

    protected Session currentSession(){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        }
        catch (HibernateException se) {
            session = sessionFactory.openSession();
        }
        return session;
    }
}
