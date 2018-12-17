package com.samuele.orm.repositories;

import java.util.List;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samuele.orm.entities.Aeroporto;

@Repository
public interface AeroportoRepository extends JpaRepository<Aeroporto, Integer>{
	
	public List<Aeroporto> findByNome(String nome);
	public List<Aeroporto> findByCittà(String città);
	public List<Aeroporto> findByNazione(String nazione);
	public List<Aeroporto> findByNazioneAndCittà(String nazione, String città);

}
