package com.samuele.orm.relations;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.samuele.orm.dbManager.DBManager;
import com.samuele.orm.services.AereoService;
import com.samuele.orm.services.AeroportoService;
import com.samuele.orm.services.CompagniaAereaService;
import com.samuele.orm.services.VoloService;

@SuppressWarnings("unused")
public class VoloRelations {
	
	private VoloService service;
	private AereoService serviceAereo;
	private AeroportoService serviceAeroporto;
	private CompagniaAereaService serviceCompagnia;
	
	public VoloRelations() {
		
		this.service = new VoloService();
		this.serviceAereo = new AereoService();
		this.serviceAeroporto = new AeroportoService();
		this.serviceCompagnia = new CompagniaAereaService();
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
	public void test() {
	}

}
