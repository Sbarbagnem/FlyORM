package com.samuele.orm.repositories;

import org.junit.runner.RunWith; 
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AereoRepositoryTest.class, AeroportoRepositoryTest.class, CompagniaAereaRepositoryTest.class,
		VoloRepositoryTest.class })
public class AllTests {

}
