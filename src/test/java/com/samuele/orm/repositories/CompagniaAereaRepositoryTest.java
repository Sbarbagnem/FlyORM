package com.samuele.orm.repositories;

import static org.junit.Assert.assertEquals; 

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;

import com.samuele.orm.dbManager.DBManager;
import com.samuele.orm.entities.CompagniaAerea;
import com.samuele.orm.services.CompagniaAereaService;
 
//@RunWith(SpringRunner.class)
//@DataJpaTest
public class CompagniaAereaRepositoryTest {
	
	private CompagniaAereaService service;
	
	public CompagniaAereaRepositoryTest() {
		this.service = new CompagniaAereaService();
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
	public void testCreate(){
		CompagniaAerea c1 = new CompagniaAerea("nome1", "Italia", null);
		CompagniaAerea c2 = new CompagniaAerea("nome2", "Italia", null);
		CompagniaAerea c3 = new CompagniaAerea("nome3", "Italia", null);
		
		service.save(c1);
		service.save(c2);
		service.save(c3);
		
		List<CompagniaAerea> compagnie = service.getAll();
		
		assertEquals(3, compagnie.size());
	}
	
	@Test
	public void testRead(){
		
		CompagniaAerea c1 = new CompagniaAerea("nome1", "Italia", null);
		CompagniaAerea c2 = new CompagniaAerea("nome2", "Italia", null);
		CompagniaAerea c3 = new CompagniaAerea("nome3", "Italia", null);
		
		service.save(c1);
		service.save(c2);
		service.save(c3);
		
		CompagniaAerea nome1 = service.get(c1.getId());
		
		assertEquals(nome1.getNome(), c1.getNome());
		assertEquals(nome1.getNazione(), c1.getNazione());
	}
	
	@Test
	public void testUpdate() {
		CompagniaAerea c1 = new CompagniaAerea("nome1", "Italia", null);
		
		service.save(c1);
		
		c1.setNome("nome1.1");
		
		List<CompagniaAerea> compagnie = service.getAll();
		
		assertEquals(1, compagnie.size());
		assertEquals("nome1.1", compagnie.get(0).getNome());
	}
	
	@Test
	public void testDelete() {
		CompagniaAerea c1 = new CompagniaAerea("nome1", "Italia", null);
		CompagniaAerea c2 = new CompagniaAerea("nome2", "Italia", null);
		CompagniaAerea c3 = new CompagniaAerea("nome3", "Italia", null);
		
		service.save(c1);
		service.save(c2);
		service.save(c3);
		
		service.delete(c1);
		
		List<CompagniaAerea> compagnie = service.getAll();
		
		assertEquals(2, compagnie.size());
		assertEquals(c2.getId(), compagnie.get(0).getId());
		assertEquals(c3.getId(), compagnie.get(1 ).getId());		
	}
	
	@Test
	public void testSearch() {
		
		CompagniaAerea c1 = new CompagniaAerea("nome1", "Italia", null);
		CompagniaAerea c2 = new CompagniaAerea("nome2", "Italia", null);
		CompagniaAerea c3 = new CompagniaAerea("nome3", "Germania", null);
		
		service.save(c1);
		service.save(c2);
		service.save(c3);
		
		List<CompagniaAerea> compagnie = service.search("nazione", "Italia");
		
		assertEquals(2, compagnie.size());
		
		compagnie = service.search("nome", "nome1");
		
		assertEquals(1, compagnie.size());
		assertEquals("nome1", compagnie.get(0).getNome());
		assertEquals("Italia", compagnie.get(0).getNazione());
	}
}
