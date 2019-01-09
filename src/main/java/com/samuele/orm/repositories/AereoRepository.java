package com.samuele.orm.repositories;

import java.util.List;

import javax.persistence.Query;

import com.samuele.orm.entities.Aereo;

public class AereoRepository extends Repository<Aereo, Long> {
	
	public AereoRepository() {}
	
	@Override
	public Aereo create(Aereo entity) {
		getEntityManager().persist(entity);
		return entity;
	}

	@Override
	public Aereo get(Long id) {
		return getEntityManager().find(Aereo.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aereo> getAll() {
		return getEntityManager().createQuery("FROM Aereo").getResultList();
	}

	@Override
	public Aereo update(Aereo entity) {
		return getEntityManager().merge(entity);
	}

	@Override
	public void delete(Aereo entity) {
		deleteById(entity.getId());
	}
	
	@Override
	public void deleteById(Long id) {
		getEntityManager().remove(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aereo> search(String field, String value) {
		Query q = getEntityManager().createQuery("SELECT a FROM Aereo a WHERE a." + field + " LIKE :value");
		q =	q.setParameter("value", value);
		return	q.getResultList();
	}
}
