package com.samuele.orm.relations;

import static org.junit.Assert.assertEquals;   

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.samuele.orm.entities.CompagniaAerea;
import com.samuele.orm.repositories.CompagniaAereaRepository;
import com.samuele.orm.services.CompagniaAereaService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CompagniaAereaRelationsTest {
	
	private CompagniaAereaService service;
	
	public CompagniaAereaRelationsTest(){
		this.service = new CompagniaAereaService();
	}
	
	@Test
	public void selfRelation1Test() {
		
		// testo che eliminando la compagnia capo elmina anche le comapgnie del gruppo
		
		CompagniaAerea c1 = new CompagniaAerea("Nome1", "Italia", null);
		CompagniaAerea c1_1 = new CompagniaAerea("Nome1.1", "Italia", c1);
		CompagniaAerea c1_2 = new CompagniaAerea("Nome1.2", "Italia", c1);
		CompagniaAerea c2 = new CompagniaAerea("Nome2", "Italia", null);
		
		c1.getCompagnieSub().add(c1_1);
		c1.getCompagnieSub().add(c1_2);
		
		service.save(c1);
		service.save(c2);
		
		// controllo che salvando l'entità padre mi salva anche le figlie
		assertEquals(4, service.getAll().size());
		
		service.delete(c1);
		
		List<CompagniaAerea> c = service.getAll();
		
		// controllo che eliminando l'entità padre mi elimina anche le figlie
		assertEquals(1, c.size());

		drop(c2);

	}

	@Test
	public void selfRelation2Test() {
		
		// testo che eliminando una compagnia del gruppo non elimina anche le altre o il capo
		
		CompagniaAerea c1 = new CompagniaAerea("Nome1", "Italia", null);
		CompagniaAerea c1_1 = new CompagniaAerea("Nome1.1", "Italia", c1);
		CompagniaAerea c1_2 = new CompagniaAerea("Nome1.2", "Italia", c1);
		CompagniaAerea c2 = new CompagniaAerea("Nome2", "Italia", null);
		
		c1.getCompagnieSub().add(c1_1);
		c1.getCompagnieSub().add(c1_2);
		
		service.save(c1);
		service.save(c2);
		
		c1.getCompagnieSub().remove(c1_1);

		service.delete(c1_1);
		
		List<CompagniaAerea> c = service.getAll();
		
		assertEquals(3, c.size());
		
		drop(c1);
		drop(c2);
		
	}
	
	public void drop(CompagniaAerea c) {
		service.delete(c);
	}

}
