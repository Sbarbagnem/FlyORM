package com.samuele.orm.repositories;

import java.util.List;

import com.samuele.orm.entities.Volo;

public class VoloRepository extends Repository<Volo, Long> {
	
	public VoloRepository() {}

	@Override
	public Volo create(Volo entity) {
		getEntityManager().persist(entity);
		return entity;
	}

	@Override
	public Volo get(Long id) {
		return getEntityManager().find(Volo.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Volo> getAll() {
		return getEntityManager().createQuery("FROM Volo").getResultList();
	}

	@Override
	public Volo update(Volo entity) {
		return getEntityManager().merge(entity);
	}

	@Override
	public void delete(Volo entity) {
		deleteById(entity.getId());
	}
	
	@Override
	public void deleteById(Long id) {
		getEntityManager().remove(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Volo> search(String field, String value) {
		String query = "SELECT m FROM Volo m WHERE m." + field + " LIKE '%"+value+"%'";
    	return getEntityManager().createQuery(query).getResultList();
	}

}
