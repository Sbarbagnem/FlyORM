package com.samuele.orm.entities;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.samuele.orm.repositories.AereoRepository;
import com.samuele.orm.repositories.AeroportoRepository;
import com.samuele.orm.repositories.CompagniaAereaRepository;
import com.samuele.orm.repositories.VoloRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VoloRepositoryTest {
	
	@Autowired
	private VoloRepository voloRepo;
	@Autowired
	private CompagniaAereaRepository compagniaRepo;
	@Autowired
	private AeroportoRepository aeroportoRepo;
	@Autowired
	private AereoRepository aereoRepo;
	
	private	CompagniaAerea	c1;
	private	Aeroporto a1;
	private Aeroporto a2;
	private Aereo aereo1;
	private Date dataPartenza;
	private Date dataArrivo;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		
		c1 = new CompagniaAerea("Nome1", "Italia", null);
		a1 = new Aeroporto("Malpensa", "Milano", "Italia");
		a2 = new Aeroporto("Berlino", "Berlino", "Germania");
		aereo1 = new Aereo("Boeing", "757");	
		
		dataPartenza = new Date("1/1/2019");
		dataArrivo = new Date("2/1/2019");
		
		compagniaRepo.saveAndFlush(c1);
		aeroportoRepo.saveAndFlush(a1);
		aeroportoRepo.saveAndFlush(a2);
		aereoRepo.saveAndFlush(aereo1);	
	}
	
	@Test
	public void testCreateAndRead() {
		
		Volo v1 = new Volo(dataPartenza, dataArrivo, a1, a2, c1, aereo1);
		
		voloRepo.saveAndFlush(v1);
		
		Volo v1_create = voloRepo.findById(v1.getId()).get();
		
		assertEquals(v1.getId(), v1_create.getId());
		
		
	}
	
	@Test
	public void updateVoloTest() {
		
		Volo v1 = new Volo(dataPartenza, dataArrivo, a1, a2, c1, aereo1);
		
		voloRepo.saveAndFlush(v1);
		
		v1.setAeroportoArrivo(new Aeroporto("Berlino2","Berlino","Germania"));
		
		Volo v1_update = voloRepo.findById(v1.getId()).get();
		
		assertEquals(v1_update.getId(), v1.getId());
		assertEquals(v1_update.getAeroportoArrivo().getNome(), "Berlino2");
		
	}
	
	@Test
	public void deleteVoloTest() {
		
		Volo v1 = new Volo(dataPartenza, dataArrivo, a1, a2, c1, aereo1);
		
		voloRepo.saveAndFlush(v1);
		
		voloRepo.deleteById(v1.getId());
		
		List<Volo> voli = voloRepo.findAll();
		
		assertEquals(0, voli.size());
		
	}

}
