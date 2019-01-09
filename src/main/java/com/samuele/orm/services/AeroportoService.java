package com.samuele.orm.services;

import java.util.List;

import com.samuele.orm.entities.Aeroporto;
import com.samuele.orm.repositories.AeroportoRepository;

public class AeroportoService implements Services<Aeroporto, Long> {
	
	private AeroportoRepository repo;
	
	public AeroportoService() {
		this.repo = new AeroportoRepository();
	}

	@Override
	public Aeroporto save(Aeroporto t) {
		repo.open();
		repo.create(t);
		repo.close();
		return t;
	}

	@Override
	public Aeroporto get(Long id) {
		repo.open();
		Aeroporto trovato = repo.get(id);
		repo.close();
		return trovato;
	}

	@Override
	public List<Aeroporto> getAll() {
		repo.open();
		List<Aeroporto> trovati = repo.getAll();
		repo.close();
		return trovati;
	}

	@Override
	public Aeroporto edit(Aeroporto t) {
		repo.open();
		Aeroporto modificato = repo.update(t);
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
	public void delete(Aeroporto t) {
		repo.open();
		repo.delete(t);
		repo.close();
	}

	@Override
	public List<Aeroporto> search(String field, String value) {
		repo.open();
		List<Aeroporto> trovati = repo.search(field, value);
		repo.close();
		return trovati;
	}

}
