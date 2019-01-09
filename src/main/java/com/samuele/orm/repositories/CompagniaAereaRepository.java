package com.samuele.orm.repositories;

import java.util.List;

import javax.persistence.Query;

import com.samuele.orm.entities.CompagniaAerea;

public class CompagniaAereaRepository extends Repository<CompagniaAerea, Long> {
	
	public CompagniaAereaRepository() {}

	@Override
	public CompagniaAerea create(CompagniaAerea entity) {
		getEntityManager().persist(entity);
		return entity;
	}

	@Override
	public CompagniaAerea get(Long id) {
		return getEntityManager().find(CompagniaAerea.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompagniaAerea> getAll() {
		return getEntityManager().createQuery("FROM CompagniaAerea").getResultList();
	}

	@Override
	public CompagniaAerea update(CompagniaAerea entity) {
		return getEntityManager().merge(entity);
	}

	@Override
	public void delete(CompagniaAerea entity) {
		deleteById(entity.getId());
	}
	
	@Override
	public void deleteById(Long id) {
		getEntityManager().remove(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompagniaAerea> search(String field, String value) {
		Query q = getEntityManager().createQuery("SELECT a FROM CompagniaAerea a WHERE a." + field + " LIKE :value");
		q =	q.setParameter("value", value);
		return	q.getResultList();
	}
}
