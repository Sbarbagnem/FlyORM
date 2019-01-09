package com.samuele.orm.services;

import java.util.List;

import com.samuele.orm.entities.Aereo;
import com.samuele.orm.repositories.AereoRepository;

public class AereoService implements Services<Aereo, Long> {
	
	private AereoRepository repo;
	
	public AereoService() {
		this.repo = new AereoRepository();
	}

	@Override
	public Aereo save(Aereo t) {
		
		repo.open();
		Aereo a = repo.create(t);
		repo.close();
		return a;
	}

	@Override
	public Aereo get(Long id) {
		
		repo.open();
		Aereo trovato = repo.get(id);
		repo.close();
		return trovato;	
	}

	@Override
	public List<Aereo> getAll() {
		
		repo.open();
		List<Aereo> aerei = repo.getAll();
		repo.close();
		return aerei;
	}

	@Override
	public Aereo edit(Aereo t) {
		
		repo.open();
		Aereo modificato = repo.update(t);
		repo.close();
		return modificato;
		
	}

	@Override
	public void delete(Aereo t) {
		repo.open();
		repo.delete(t);
		repo.close();
	}
	
	@Override
	public void deleteById(Long id) {
		repo.open();
		repo.deleteById(id);
		repo.close();
	}

	@Override
	public List<Aereo> search(String field, String value){
		repo.open();
        List<Aereo> results = repo.search(field, value);
        repo.close();
        return results;

	}
}
