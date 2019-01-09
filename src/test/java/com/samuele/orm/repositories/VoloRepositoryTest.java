package com.samuele.orm.repositories;

import static org.junit.Assert.*;   

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.samuele.orm.dbManager.DBManager;
import com.samuele.orm.entities.*;
import com.samuele.orm.services.*;
 
public class VoloRepositoryTest {

	private VoloService service;
	private AereoService serviceAereo;
	private AeroportoService serviceAeroporto;
	private CompagniaAereaService serviceCompagnia;
	
	private Aereo aereo1;
	private Aereo aereo2;
	
	private Aeroporto aeroporto1;
	private Aeroporto aeroporto2;
	
	private CompagniaAerea compagnia1;
	private CompagniaAerea compagnia2;
	
	private Volo volo1;
	private Volo volo2;
	private Volo volo3;
	
	@SuppressWarnings("deprecation")
	public VoloRepositoryTest(){
		
		this.service = new VoloService();
		this.serviceAereo = new AereoService();
		this.serviceAeroporto = new AeroportoService();
		this.serviceCompagnia = new CompagniaAereaService();
		
		this.aereo1 = new Aereo("Airbus", "A300");
		this.aereo2 = new Aereo("Boing", "777");
		this.aeroporto1 = new Aeroporto("Malpensa", "Milano", "Italia");
		this.aeroporto2 = new Aeroporto("Berlino", "Berlino", "Germania");
		this.compagnia1 = new CompagniaAerea("Compagnia1", "Italia", null);
		this.compagnia2 = new CompagniaAerea("Compagnia2", "Italia", null);
		int anno = 2019 - 1900;
		this.volo1 = new Volo(new Date(anno,1,1), new Date(anno,1,2), aeroporto1, aeroporto2, compagnia1, aereo1);
		this.volo2 = new Volo(new Date(anno,1,3), new Date(anno,1,4), aeroporto1, aeroporto2, compagnia1, aereo1);
		this.volo3 = new Volo(new Date(anno,2,1), new Date(anno,2,2), aeroporto2, aeroporto1, compagnia2, aereo2);
	}
	
	// salvo oggetti che uso in ogni caso di test
	public void setObject() {
		serviceAeroporto.save(aeroporto1);
		serviceAeroporto.save(aeroporto2);
		serviceCompagnia.save(compagnia1);
		serviceCompagnia.save(compagnia2);
		serviceAereo.save(aereo1);
		serviceAereo.save(aereo2);
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
	public void testCreate() {
		
		setObject(); 
		
		service.save(volo1);
		service.save(volo2);
		service.save(volo3);
		
		List<Volo> voli = service.getAll();
		
		// testo che abbia salvato i due oggetti
		assertEquals(3, voli.size());
	}
	
	@Test
	public void testRead() {
		
		setObject();
		
		service.save(volo1);
		service.save(volo2);
		service.save(volo3);
		
		Volo v1 = service.get(volo1.getId());
		Volo v2 = service.get(volo2.getId());
		Volo v3 = service.get(volo3.getId());
		
		assertEquals(volo1.getId(), v1.getId());
		assertEquals(volo2.getId(), v2.getId());
		assertEquals(volo3.getId(), v3.getId());
	}
	
	@Test
	public void testUpdate() {
		
		setObject();
	
		service.save(volo1);
		
		volo1.setAereo(aereo2);
		
		service.edit(volo1);
		
		Volo modificato = service.get(volo1.getId());
		
		assertEquals(aereo2, modificato.getAereo());
		
	}
	
	@Test
	public void testDelete() {
		
		setObject();
		
		service.save(volo1);
		service.save(volo2);
		
		service.delete(volo1);
		
		List<Volo> modificato = service.getAll();
		
		assertEquals(1, modificato.size());
		assertEquals(volo2.getId(), modificato.get(0).getId());
		
	}
}
