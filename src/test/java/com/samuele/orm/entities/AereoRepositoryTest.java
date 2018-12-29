package com.samuele.orm.entities;

import static org.junit.Assert.assertEquals; 

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.samuele.orm.repositories.AereoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AereoRepositoryTest {
	
	@Autowired
	private AereoRepository aereoRepo;
	
	@Test
	public void testCreateAndRead() {
		
		Aereo a1 = new Aereo("Airbus", "A300");
		Aereo a2 = new Aereo("Boeing", "757");
		
		aereoRepo.saveAndFlush(a1);
		aereoRepo.saveAndFlush(a2);
		
		List<Aereo> aerei = aereoRepo.findAll();
		
		assertEquals(2, aerei.size());
		
		Optional<Aereo> aereo = aereoRepo.findById(a1.getId());
		
		assertEquals("Airbus", aereo.get().getMarca());
		assertEquals("A300", aereo.get().getModello());
	
	}
	
	@Test
	public void testUpdate() {
		
		Aereo a1 = new Aereo("Airbus", "A300");
		aereoRepo.saveAndFlush(a1);
		
		a1.setModello("A301");
		
		List<Aereo> aerei = aereoRepo.findAll();
		
		assertEquals(1, aerei.size());
		assertEquals("A301", aerei.get(0).getModello());
		
	}
	
	@Test
	public void testDelete() {
		
		Aereo a1 = new Aereo("Airbus", "A300");
		aereoRepo.saveAndFlush(a1);
		
		Optional<Aereo> aereo = aereoRepo.findById(a1.getId());

		assertEquals("A300", aereo.get().getModello());
		
		aereoRepo.deleteById(a1.getId());
		
		List<Aereo> aerei = aereoRepo.findAll();
		
		assertEquals(0, aerei.size());
		
		
	}

}