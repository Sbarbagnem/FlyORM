package com.samuele.orm.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.samuele.orm.repositories.CompagniaAereaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CompagniaAereaRepositoryTest {
	
	@Autowired
	private CompagniaAereaRepository compagniaRepo;
	
	private CompagniaAerea c1;
	private CompagniaAerea c1_1;
	private CompagniaAerea c1_2;

	@Before
	public void setUp() {
		
		c1 = new CompagniaAerea("Nome1", "Italia", null);
		c1_1 = new CompagniaAerea("Nome1.1", "Italia", c1);
		c1_2 = new CompagniaAerea("Nome1.2", "Italia", c1);

	}
	
	@Test
	public void createCompagniaTest(){
		
		compagniaRepo.saveAndFlush(c1);
		compagniaRepo.saveAndFlush(c1_1);
		compagniaRepo.saveAndFlush(c1_2);
		
		List<CompagniaAerea> compagnie = compagniaRepo.findAll();
		
		// controllo che siano stati inseriti 3 oggetti
		assertEquals(3, compagnie.size());
	
		// controllo che gli id dei tre oggetti non siano null
		assertNotNull(compagnie.get(0).getId());
		assertNotNull(compagnie.get(1).getId());
		assertNotNull(compagnie.get(2).getId());
	}
	
	@Test
	public void readCompagniaTest(){
		
		compagniaRepo.saveAndFlush(c1);
		
		CompagniaAerea compagnia = compagniaRepo.findById(c1.getId()).get();

		// controllo che l'oggetto selezionato abbia gli attributi giusti
		assertEquals("Nome1", compagnia.getNome());
		assertEquals("Italia", compagnia.getNazione());
		assertNull(compagnia.getCompagniaGruppo());
		
	}
	
	@Test
	public void updateCompagniaTest() {
		
		compagniaRepo.saveAndFlush(c1);
		
		c1.setNome("Nome2");
		
		List<CompagniaAerea> compagnie = compagniaRepo.findAll();
		
		// testo che non abbia creato un nuovo oggetto
		assertEquals(1, compagnie.size());
		
		// testo che l'oggetto abbia lo stesso id di quello inserito
		// quindi sia lo stesso oggetto ma con nome modificato
		assertEquals(c1.getId(), compagnie.get(0).getId());
		assertEquals(c1.getNome(), "Nome2");
		
	}
	
	@Test
	public void deleteCompagniaTest() {
		
		compagniaRepo.saveAndFlush(c1);
		compagniaRepo.saveAndFlush(c1_1);
		
		compagniaRepo.delete(c1_1);
		
		List<CompagniaAerea> compagnie = compagniaRepo.findAll();
		
		// testo che abbia eliminato un oggetto
		assertEquals(1, compagnie.size());
		
		// testo che abbia eliminato l'oggetto giusto
		assertEquals(c1.getId(), compagnie.get(0).getId());
		
	}
	
//	@Test
//	public void relationCompagniaSubTest() {
//		
//		// testo la self-relation della entità compagniaAerea
//		
//		compagniaRepo.saveAndFlush(c1);
//		compagniaRepo.saveAndFlush(c1_1);
//		compagniaRepo.saveAndFlush(c1_2);
//		
//		c1_1.setCompagniaGruppo(c1);
//		c1_2.setCompagniaGruppo(c1);
//		
////		CompagniaAerea capoGruppo = compagniaRepo.findById(c1.getId()).get();
////		List<CompagniaAerea> subGruppo = capoGruppo.getCompagnieSub();
//		
////		assertEquals(2, subGruppo.size());
//		
//		// cancello la compagnia a capo del gruppo
//		compagniaRepo.delete(c1);
//		
//		CompagniaAerea compagnia = compagniaRepo.findById(c1_1.getId()).get();
//		
//		assertNull(compagnia.getCompagniaGruppo());
//	}
//
}
