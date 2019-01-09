package com.samuele.orm.repositories;

import java.util.List;

import javax.persistence.Query;

import com.samuele.orm.entities.Aeroporto;

public class AeroportoRepository extends Repository<Aeroporto, Long> {
	
	public AeroportoRepository() {}

	@Override
	public Aeroporto create(Aeroporto entity) {
		getEntityManager().persist(entity);
		return entity;
	}

	@Override
	public Aeroporto get(Long id) {
		return getEntityManager().find(Aeroporto.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aeroporto> getAll() {
		return getEntityManager().createQuery("FROM Aeroporto").getResultList();
	}

	@Override
	public Aeroporto update(Aeroporto entity) {
		return getEntityManager().merge(entity);
	}

	@Override
	public void delete(Aeroporto entity) {
		deleteById(entity.getId());
		
	}
	
	@Override
	public void deleteById(Long id) {
		getEntityManager().remove(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aeroporto> search(String field, String value) {
		Query q = getEntityManager().createQuery("SELECT a FROM Aeroporto a WHERE a." + field + " LIKE :value");
		q =	q.setParameter("value", value);
		return	q.getResultList();
	}

}
