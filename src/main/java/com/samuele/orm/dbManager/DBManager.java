package com.samuele.orm.dbManager;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DBManager {
	
	public static void dropDB() {
		
		EntityManager entityManager = Persistence.createEntityManagerFactory("flyDB").createEntityManager();
		
		String query = "DELETE IGNORE FROM ";
		
		entityManager.getTransaction().begin();
		entityManager.createNativeQuery(query + "volo").executeUpdate();
		entityManager.createNativeQuery(query + "aereo").executeUpdate();
		entityManager.createNativeQuery(query + "aeroporto").executeUpdate();
		entityManager.createNativeQuery(query + "compagniaAerea").executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
