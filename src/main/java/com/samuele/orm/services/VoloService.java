package com.samuele.orm.services;

import java.util.Date;
import java.util.List;

import com.samuele.orm.entities.Aeroporto;
import com.samuele.orm.entities.Volo;
import com.samuele.orm.repositories.VoloRepository;

public class VoloService implements Services<Volo, Long> {

	private VoloRepository repo;
	
	public VoloService() {
		this.repo = new VoloRepository();
	}
	@Override
	public Volo save(Volo t) {
		repo.open();
		repo.create(t);
		repo.close();
		return t;
	}

	@Override
	public Volo get(Long id) {
		repo.open();
		Volo trovato = repo.get(id);
		repo.close();
		return trovato;
	}

	@Override
	public List<Volo> getAll() {
		repo.open();
		List<Volo> trovati = repo.getAll();
		repo.close();
		return trovati;
	}

	@Override
	public Volo edit(Volo t) {
		repo.open();
		Volo modificato = repo.update(t);
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
	public void delete(Volo t) {
		repo.open();
		repo.delete(t);
		repo.close();
	}

	@Override
	public List<Volo> search(String field, String value) {
		repo.open();
		List<Volo> trovati = repo.search(field, value);
		repo.close();
		return trovati;
	}
}
