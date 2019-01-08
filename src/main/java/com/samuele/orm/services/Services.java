package com.samuele.orm.services;

import java.io.Serializable;
import java.util.List;

public interface Services<T, id extends Serializable> {

	public T save(T t);
	public T get(Long id);
	public List<T> getAll();
	public T edit(T t);
	public void deleteById(Long id);
	public void delete(T t);
	public List<T> search(String field, String value);
	
}
