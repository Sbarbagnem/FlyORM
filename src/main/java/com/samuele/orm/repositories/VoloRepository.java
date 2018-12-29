package com.samuele.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samuele.orm.entities.Volo;

public interface VoloRepository extends JpaRepository<Volo, Long> {

}
