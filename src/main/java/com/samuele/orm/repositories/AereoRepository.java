package com.samuele.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.samuele.orm.entities.Aereo;

public interface AereoRepository extends JpaRepository<Aereo, Long> {
	
	

}
