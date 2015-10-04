package com.plantplaces.dao;

import java.util.List;

import org.junit.Test;

import com.plantplaces.dto.Plant;

import junit.framework.TestCase;

public class TestPlantHbmDAO extends TestCase {
	
	private IPlantDAO plantHbmDAO;
	private List<Plant> plants;

	@Test
	public void testFetchByCommonName() {
		givenPlantDAOInstantiated();
		whenCommonNameIsRedbud();
		thenVerifyResults();
	}

	private void thenVerifyResults() {
		// TODO Auto-generated method stub
		assertTrue(plants.size() > 0);
		for (Plant plant : plants) {
			assertEquals("Redbubd", plant.getCommon());
		}
		
	}

	private void whenCommonNameIsRedbud() {
		// TODO Auto-generated method stub
		Plant p = new Plant();
		p.setCommon("Redbubd");
		plants = plantHbmDAO.fetchPlants(p);
		
	}

	private void givenPlantDAOInstantiated() {
		// TODO Auto-generated method stub
		plantHbmDAO = new PlantHbmDAO();
	}

}
