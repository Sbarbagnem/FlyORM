package com.samuele.orm.repositories;
 
import org.junit.Test;       
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.samuele.orm.entities.Aeroporto;
import com.samuele.orm.repositories.AeroportoRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
 
@RunWith(SpringRunner.class)
@DataJpaTest
public class AeroportoRepositoryTest {
	
	@Autowired
	private TestEntityManager em;
	
	@Autowired
	private AeroportoRepository aeroportoRepository;

	@Test
	public void testFindByName() {
	
		Aeroporto a1 = new Aeroporto("Malpensa", "Milano", "Italia");
		
		em.persist(a1);
		em.flush();
		
		List<Aeroporto> aeroporti = aeroportoRepository.findByNome(a1.getNome());
		
		assertThat(1).isEqualTo(aeroporti.size());
	}
	
	@Test
	// testo ricerca di tutti gli aeroporti nella città di una nazione
	public void testFindByNazioneAndCittà() {
		
		Aeroporto a1 = new Aeroporto("Malpensa", "Milano", "Italia");
		Aeroporto a2 = new Aeroporto("Linate", "Milano", "Italia");
		Aeroporto a3 = new Aeroporto("Sydney", "Sydney", "Australia");
		Aeroporto a4 = new Aeroporto("Sydney", "Sydney", "Canada");
		Aeroporto a5 = new Aeroporto("Ciampino", "Roma", "Italia");
		
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		em.persist(a4);
		em.persist(a5);
		em.flush();
		
		List<Aeroporto> aeroporti = aeroportoRepository.findByNazioneAndCittà("Australia", "Sydney");
		
		assertThat(1).isEqualTo(aeroporti.size());
		
		aeroporti = aeroportoRepository.findByNazioneAndCittà("Italia", "Milano");
		
		assertThat(2).isEqualTo(aeroporti.size());
		
		
	}
}
