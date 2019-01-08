package com.samuele.orm.services;

import java.util.List;

import com.samuele.orm.entities.CompagniaAerea;
import com.samuele.orm.repositories.CompagniaAereaRepository;

public class CompagniaAereaService implements Services<CompagniaAerea, Long> {
	
	private CompagniaAereaRepository repo;
	
	public CompagniaAereaService() {
		this.repo = new CompagniaAereaRepository();
	}

	@Override
	public CompagniaAerea save(CompagniaAerea t) {
		
		repo.open();
		repo.create(t);
		repo.close();
		return t;
	}

	@Override
	public CompagniaAerea get(Long id) {
		
		repo.open();
		CompagniaAerea trovato = repo.get(id);
		repo.close();
		return trovato;	
	}

	@Override
	public List<CompagniaAerea> getAll() {
		
		repo.open();
		List<CompagniaAerea> compagnie = repo.getAll();
		repo.close();
		return compagnie;
	}

	@Override
	public CompagniaAerea edit(CompagniaAerea t) {
		
		repo.open();
		CompagniaAerea modificato = repo.update(t);
		repo.close();
		return modificato;
		
	}

	@Override
	public void deleteById(Long id) {
		repo.open();
		repo.deleteById(id);
		repo.close();
	}

	@Override
	public void delete(CompagniaAerea t) {
		repo.open();
		repo.delete(t);
		repo.close();
	}

	@Override
	public List<CompagniaAerea> search(String field, String value){
		repo.open();
        List<CompagniaAerea> results = repo.search(field, value);
        repo.close();
        return results;

	}
}
