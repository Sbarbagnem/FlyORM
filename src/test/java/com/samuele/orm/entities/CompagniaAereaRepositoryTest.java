package com.samuele.orm.entities;

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
	private CompagniaAereaRepository CompagniaRepo;
	
	@Test
	public void createCompagniaTest(){
		
	}
	
	@Test
	public void readCompagniaTest(){
		
	}
	
	@Test
	public void updateCompagniaTest() {
		
	}
	
	@Test
	public void deleteCompagniaTest() {
		
	}

}
