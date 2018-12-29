package com.samuele.orm.entities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.samuele.orm.repositories.VoloRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VoloRepositoryTest {
	
	@Autowired
	private VoloRepository VoloRepo;
	
	@Test
	public void createVoloTest() {
		
	}
	
	@Test
	public void readVoloTest() {
		
	}
	
	@Test
	public void updateVoloTest() {
		
	}
	
	@Test
	public void deleteVoloTest() {
		
	}

}
