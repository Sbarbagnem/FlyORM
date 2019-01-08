package com.samuele.orm.dbManager;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DBManager {
	
	public static void dropDB() {
		
		EntityManager em = Persistence.createEntityManagerFactory("fly").createEntityManager();
		
		String query = "TRUNCATE ";
		em.getTransaction().begin();
		em.createNativeQuery(query + "aereo").executeUpdate();
		em.createNativeQuery(query + "aeroporto").executeUpdate();
		em.createNativeQuery(query + "compagniaAerea").executeUpdate();
		em.createNativeQuery(query + "volo").executeUpdate();
		em.getTransaction().commit();
		em.close();
	}

}
