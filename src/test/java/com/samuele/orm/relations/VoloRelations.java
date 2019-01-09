package com.samuele.orm.relations;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.samuele.orm.dbManager.DBManager;
import com.samuele.orm.entities.Aereo;
import com.samuele.orm.entities.Aeroporto;
import com.samuele.orm.entities.CompagniaAerea;
import com.samuele.orm.entities.Volo;
import com.samuele.orm.services.AereoService;
import com.samuele.orm.services.AeroportoService;
import com.samuele.orm.services.CompagniaAereaService;
import com.samuele.orm.services.VoloService;

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

	@SuppressWarnings("deprecation")
	@Test
	public void testDeleteCompagnia() {
		
		// test se elimino compagnia che offre un volo allora elimino voli di quella compagnia
		
		Aereo aereo1 = new Aereo("Airbus", "A300");
		Aereo aereo2 = new Aereo("Boing", "777");
		Aeroporto aeroporto1 = new Aeroporto("Malpensa", "Milano", "Italia");
		Aeroporto aeroporto2 = new Aeroporto("Berlino", "Berlino", "Germania");
		Aeroporto aeroporto3 = new Aeroporto("Barcellona", "Barcellona", "Spagna");
		CompagniaAerea compagnia1 = new CompagniaAerea("Compagnia1", "Italia", null);
		CompagniaAerea compagnia2 = new CompagniaAerea("Compagnia2", "Italia", null);
		int anno = 2019 - 1900;
		Volo volo1 = new Volo(new Date(anno,1,1), new Date(anno,1,2), aeroporto1, aeroporto2, compagnia1, aereo1);
		Volo volo2 = new Volo(new Date(anno,1,3), new Date(anno,1,4), aeroporto1, aeroporto2, compagnia1, aereo1);
		Volo volo3 = new Volo(new Date(anno,2,1), new Date(anno,2,2), aeroporto2, aeroporto3, compagnia2, aereo2);
		
		serviceAereo.save(aereo1);
		serviceAereo.save(aereo2);
		serviceAeroporto.save(aeroporto1);
		serviceAeroporto.save(aeroporto2);
		serviceAeroporto.save(aeroporto3);
		serviceCompagnia.save(compagnia1);
		serviceCompagnia.save(compagnia2);
		service.save(volo1);
		service.save(volo2);
		service.save(volo3);
		
		compagnia1.getVoliOfferti().add(volo1);
		compagnia1.getVoliOfferti().add(volo2);
		compagnia2.getVoliOfferti().add(volo3);
		
		serviceCompagnia.delete(compagnia1);
		
		List<Volo> voliRimasti = service.getAll();
		
		assertEquals(1, voliRimasti.size());
		assertEquals(volo3, voliRimasti.get(0));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testDeleteAeroporto() {
		
		// test se elimino aeroporto che è referenziato da un volo elimino anche volo
		
		Aereo aereo1 = new Aereo("Airbus", "A300");
		Aereo aereo2 = new Aereo("Boing", "777");
		Aeroporto aeroporto1 = new Aeroporto("Malpensa", "Milano", "Italia");
		Aeroporto aeroporto2 = new Aeroporto("Berlino", "Berlino", "Germania");
		Aeroporto aeroporto3 = new Aeroporto("Barcellona", "Barcellona", "Spagna");
		CompagniaAerea compagnia1 = new CompagniaAerea("Compagnia1", "Italia", null);
		CompagniaAerea compagnia2 = new CompagniaAerea("Compagnia2", "Italia", null);
		int anno = 2019 - 1900;
		Volo volo1 = new Volo(new Date(anno,1,1), new Date(anno,1,2), aeroporto1, aeroporto2, compagnia1, aereo1);
		Volo volo2 = new Volo(new Date(anno,1,3), new Date(anno,1,4), aeroporto1, aeroporto2, compagnia1, aereo1);
		Volo volo3 = new Volo(new Date(anno,2,1), new Date(anno,2,2), aeroporto2, aeroporto3, compagnia2, aereo2);
		
		serviceAereo.save(aereo1);
		serviceAereo.save(aereo2);
		serviceAeroporto.save(aeroporto1);
		serviceAeroporto.save(aeroporto2);
		serviceAeroporto.save(aeroporto3);
		serviceCompagnia.save(compagnia1);
		serviceCompagnia.save(compagnia2);
		service.save(volo1);
		service.save(volo2);
		service.save(volo3);
		
		aeroporto1.getVoliInPartenza().add(volo1);
		aeroporto2.getVoliInArrivo().add(volo1);
		aeroporto1.getVoliInPartenza().add(volo2);
		aeroporto2.getVoliInArrivo().add(volo2);
		aeroporto2.getVoliInPartenza().add(volo3);
		aeroporto3.getVoliInArrivo().add(volo3);
		
		serviceAeroporto.delete(aeroporto1);
		
		List<Volo> voliRimasti = service.getAll();
		
		assertEquals(1, voliRimasti.size());
		assertEquals(volo3, voliRimasti.get(0));
		
		serviceAeroporto.delete(aeroporto3);
		
		voliRimasti = service.getAll();
		
		assertEquals(0, voliRimasti.size());
	}
}
