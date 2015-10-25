package com.plantplaces.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.plantplaces.dto.Plant;

@Named("plantDAO")
public class PlantDAOStub implements IPlantDAO {
	
	static final Logger log = Logger.getLogger(PlantDAOStub.class);

	@Override
	public List<Plant> fetchPlants() {
		// TODO Auto-generated method stub
		List<Plant> allPlants = new ArrayList<Plant>();

		// Create plants and add them to the collection.
		Plant redbud = new Plant();
		redbud.setName("Eastern Redbud");
		redbud.setGenus("Cercis");
		redbud.setSpecies("canadensis");
		redbud.setCommon("Redbubd");
		allPlants.add(redbud);

		Plant pawpaw = new Plant();
		pawpaw.setCommon("Paw Paw");
		pawpaw.setGenus("Asimina");
		pawpaw.setSpecies("triloba");
		allPlants.add(pawpaw);

		Plant nasturtium = new Plant();
		nasturtium.setCommon("nasturtium");
		nasturtium.setGenus("Trapoleanum");
		nasturtium.setSpecies("spp.");
		allPlants.add(nasturtium);
		
		Plant redMaple = new Plant();
		redMaple.setGenus("Acer");
		redMaple.setSpecies("rubrum");
		redMaple.setCommon("Red Maple");
		allPlants.add(redMaple);

		Plant redOak = new Plant();
		redOak.setGenus("Quercus");
		redOak.setSpecies("rubra");
		redOak.setCommon("Red Oak");
		allPlants.add(redOak);
		
		return allPlants;

	}

	public void insert(Plant plant) throws Exception {
		// TODO Auto-generated method stub
		log.warn("Inserting to stub; this does NOT persist the item"); 
	}

	@Override
	public void update(Plant plant) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Plant plant) throws Exception {
		// TODO Auto-generated method stub

	}

	public List<Plant> fetchPlants(Plant plant) {
		return new ArrayList<Plant>();
	}

	@Override
	public void insert(Session session, Plant plant) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Plant plant) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
