package com.example.springhibernaterelation;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Repository
public class GenericRepository<T, ID> {

  @PersistenceContext
  private EntityManager entityManager;

  public void save(T t) {
    entityManager.persist(t);
  }

  public void update(T t) {
    entityManager.merge(t);
  }

  public void delete(T t) {
    t = entityManager.merge(t);
    entityManager.remove(t);
  }

  public List<T> findAll(Class<T> aClass) {
    String entityName = aClass.getAnnotation(Entity.class).name();
    Query query = entityManager.createQuery("select entity from " + entityName + " entity");
    return query.getResultList();
  }

  public T findOne(Class<T> aClass, ID id) {
    return entityManager.find(aClass, id);
  }


}
