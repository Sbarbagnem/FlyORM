package com.samuele.orm.repositories;
 
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;          
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.samuele.orm.dbManager.DBManager;
import com.samuele.orm.entities.Aereo;
import com.samuele.orm.entities.Aeroporto;
import com.samuele.orm.repositories.AeroportoRepository;
import com.samuele.orm.services.AeroportoService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AeroportoRepositoryTest {
	
	private AeroportoService service;
	
	public AeroportoRepositoryTest() {
		this.service = new AeroportoService();
	}
	
	@Before
	public void setUp(){
		DBManager.dropDB();
	}
	
	@AfterClass
	public static void after(){
		DBManager.dropDB();
	}
	
	@Test
	public void testCreate() {
		Aeroporto a1 = new Aeroporto("Malpensa", "Milano", "Italia");
		Aeroporto a2 = new Aeroporto("Fiumicino", "Roma", "Italia");
		
		service.save(a1);
		service.save(a2);
		
		List<Aeroporto> aeroporti = service.getAll();
		
		assertEquals(2, aeroporti.size());
		
		drop(a1);
		drop(a2);

	}
	
	@Test
	public void testRead() {
		Aeroporto a1 = new Aeroporto("Malpensa", "Milano", "Italia");
		Aeroporto a2 = new Aeroporto("Fiumicino", "Roma", "Italia");
		
		service.save(a1);
		service.save(a2);
		
		Aeroporto malpensa = service.get(a1.getId());
		Aeroporto fiumicino = service.get(a2.getId());
		
		assertEquals(a1.getId(), malpensa.getId());
		assertEquals(a1.getCittà(), malpensa.getCittà());
		assertEquals(a1.getNazione(), malpensa.getNazione());
		assertEquals(a2.getId(), fiumicino.getId());
		assertEquals(a2.getCittà(), fiumicino.getCittà());
		assertEquals(a2.getNazione(), fiumicino.getNazione());
		
		drop(a1);
		drop(a2);
	}
	
	@Test
	public void testUpdate() {
		Aeroporto a1 = new Aeroporto("Malpensa", "Milano", "Italia");
		Aeroporto a2 = new Aeroporto("Fiumicino", "Roma", "Italia");
		
		service.save(a1);
		service.save(a2);
		
		a1.setCittà("Busto");
		
		service.edit(a1);
		
		List<Aeroporto> aeroporti = service.getAll();
		
		assertEquals(2, aeroporti.size());
		assertEquals("Busto", service.get(a1.getId()).getCittà());
		
		drop(a1);
		drop(a2);
		
	}
	
	@Test
	public void testDelete() {
		
		Aeroporto a1 = new Aeroporto("Malpensa", "Milano", "Italia");
		Aeroporto a2 = new Aeroporto("Fiumicino", "Roma", "Italia");
		
		service.save(a1);
		service.save(a2);
		
		service.deleteById(a1.getId());
		
		List<Aeroporto> aeroporti = service.getAll();
		
		assertEquals(1, aeroporti.size());
		assertEquals(a2.getId(), aeroporti.get(0).getId());
		
		drop(a2);	
	}
	
	@Test
	public void testSearch() {
		
	}
	
	public void drop(Aeroporto aeroporto) {
		service.delete(aeroporto);
	}
}
