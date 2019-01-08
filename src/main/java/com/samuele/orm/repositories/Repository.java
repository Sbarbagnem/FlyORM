package com.samuele.orm.repositories;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class Repository<T, ID extends Serializable>{
	
	private static EntityManager em;
	
	static {
		em = Persistence.createEntityManagerFactory("fly").createEntityManager();
	}
	
	abstract T create(T entity);
	abstract T get(ID id);
	abstract List<T> getAll();
	abstract T update(T entity);
	abstract void delete(T entity);
	abstract void deleteById(Long id);
	abstract List<T> search(String field, String value); 
	
	Repository() {}
	
	EntityManager getEntityManager() {
		return em;
	}
	
	public void open() {
		em.getTransaction().begin();
	}
	
	public void close() {
		em.flush();
		em.getTransaction().commit();
	}
	
	public void rollback() {
		em.getTransaction().rollback();
	}


}
