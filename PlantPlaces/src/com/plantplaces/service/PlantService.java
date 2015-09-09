package com.plantplaces.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dto.Plant;

@Named
public class PlantService implements IPlantService {

	@Inject
	IPlantDAO plantDAO;
	private List<Plant> allPlants;
	
	@Override
	public List<Plant> filterPlants(String filter) {
		
		if (allPlants == null ) {
			allPlants = plantDAO.fetchPlants();
		}
		
		// the collection we are returning.
		List<Plant> returnPlants = new ArrayList<Plant>();

		// filter the list.
		// interview all possible plants (allPlants), and move plants that contain the filter text into our subset collection (returnPlans)
		for (Plant plant : allPlants) {
			if (plant.toString().contains(filter)) {
				// this plant matches our criteria, so add it to the collection that will be returned from this method.
				returnPlants.add(plant);
			}
		}
		
		// TODO Auto-generated method stub
		return returnPlants;
	}

}
