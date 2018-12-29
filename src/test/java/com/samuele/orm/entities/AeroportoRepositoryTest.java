package com.samuele.orm.entities;
 
import org.junit.Before;
import org.junit.Test;          
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.samuele.orm.entities.Aeroporto;
import com.samuele.orm.repositories.AeroportoRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AeroportoRepositoryTest {
	
	@Autowired
	private AeroportoRepository aeroportoRepo;
	
	private Aeroporto a1;
	
	@Before
	public void setUp() {
		
		a1 = new Aeroporto("Malpensa", "Milano", "Italia");
		aeroportoRepo.saveAndFlush(a1);
		
	}
	
	@Test
	public void testCreateAndRead() {
			
		Optional<Aeroporto> a2 = aeroportoRepo.findById(a1.getId());

		assertEquals(a1.getId(), a2.get().getId());
	}
	
	@Test
	public void testUpdate() {
		
		Optional<Aeroporto> a2 = aeroportoRepo.findById(a1.getId());
		
		assertEquals("Malpensa", a2.get().getNome());
	
		a1.setNome("Linate");
		
		List<Aeroporto> aeroporti = aeroportoRepo.findAll();
		
		assertEquals(1, aeroporti.size());
		assertEquals("Linate", aeroporti.get(0).getNome());
		
	}
	
	@Test
	public void testDelete() {
		
		List<Aeroporto> aeroporti = aeroportoRepo.findAll();
		
		assertEquals(1, aeroporti.size());
		
		aeroportoRepo.deleteById(a1.getId());
		
		aeroporti = aeroportoRepo.findAll();
		
		assertEquals(0, aeroporti.size());
		
	}

	@Test
	public void testFindByName() {
		
		List<Aeroporto> aeroporti = aeroportoRepo.findByNome(a1.getNome());
		
		assertThat(1).isEqualTo(aeroporti.size());
	}
	
	@Test
	// testo ricerca di tutti gli aeroporti nella città di una nazione
	public void testFindByNazioneAndCittà() {

		Aeroporto a2 = new Aeroporto("Linate", "Milano", "Italia");
		Aeroporto a3 = new Aeroporto("Sydney", "Sydney", "Australia");
		Aeroporto a4 = new Aeroporto("Sydney", "Sydney", "Canada");
		Aeroporto a5 = new Aeroporto("Ciampino", "Roma", "Italia");
		
		aeroportoRepo.saveAndFlush(a2);
		aeroportoRepo.saveAndFlush(a3);
		aeroportoRepo.saveAndFlush(a4);
		aeroportoRepo.saveAndFlush(a5);
		
		List<Aeroporto> aeroporti = aeroportoRepo.findByNazioneAndCittà("Australia", "Sydney");
		
		assertThat(1).isEqualTo(aeroporti.size());
		
		aeroporti = aeroportoRepo.findByNazioneAndCittà("Italia", "Milano");
		
		assertThat(2).isEqualTo(aeroporti.size());
		
		
	}
}
