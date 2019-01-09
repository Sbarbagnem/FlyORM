package com.samuele.orm.repositories;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.samuele.orm.dbManager.DBManager;
import com.samuele.orm.entities.Aereo;
import com.samuele.orm.services.AereoService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AereoRepositoryTest {
	
	private AereoService service;
	
	public AereoRepositoryTest() {
		this.service = new AereoService();
	}	
	
	@Before
	public void setUp() {
		DBManager.dropDB();
	}
	
	@AfterClass
	public static void cleanDB() {
		DBManager.dropDB();
	}
	
	@Test
	public void testCreate() {
		
		Aereo a1 = new Aereo("Airbus", "A301");
		Aereo a2 = new Aereo("Boeing", "758");
		
		service.save(a1);
		service.save(a2);

		List<Aereo> aerei = service.getAll();
		
		// testo che abbia salvato i due oggetti
		assertEquals(2, aerei.size());
	}

	@Test
	public void testRead() {
		
		Aereo a1 = new Aereo("Airbus", "A300");
		
		service.save(a1);
		
		Aereo trovato = service.get(a1.getId());
		
		assertEquals(trovato.getId(), a1.getId());
		
	}

	@Test
	public void testUpdate() {
		
		Aereo a1 = new Aereo("Airbus", "A300");
		Aereo a2 = new Aereo("Boeing", "757");
		
		service.save(a1);
		service.save(a2);
		
		a1.setModello("NuovoModello");
		
		service.edit(a1);
		
		Aereo trovato = service.get(a1.getId());
		
		assertEquals("NuovoModello", trovato.getModello());
	}

	@Test
	public void testDelete() {
		
		Aereo a1 = new Aereo("Airbus", "A300");
		Aereo a2 = new Aereo("Airbus", "A301");
		
		service.save(a1);
		service.save(a2);
		
		service.delete(a1);
		
		List<Aereo> aerei = service.getAll();

		assertEquals(false, aerei.contains(a1));	

	}
	
	@Test
	public void testSearch() {
		Aereo a1 = new Aereo("Airbus", "100");
		Aereo a2 = new Aereo("Boing", "B100");
		Aereo a3 = new Aereo("Airbus", "200");
		Aereo a4 = new Aereo("Airbus", "201");
		
		service.save(a1);
		service.save(a2);
		service.save(a3);
		service.save(a4);
		
		List<Aereo> aerei_airbus = service.search("marca", "Airbus");
		
		assertEquals(3, aerei_airbus.size());
	}
}
