package com.samuele.orm.services;

import org.junit.runner.RunWith; 
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AereoTest.class, AeroportoTest.class, CompagniaAereaTest.class,
		VoloTest.class })
public class TestAllEntities {

}
