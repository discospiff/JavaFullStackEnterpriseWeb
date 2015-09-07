package com.plantplaces.ui;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Plant;

@Named
@ManagedBean
@Scope("session")
public class SearchPlants {


	@Inject
	private Plant plant;
	
	public String execute() {
		
		if (plant != null && plant.getName().equalsIgnoreCase("Redbud")) {
			return "search";
			
		} else {
			return "noresults";
		}
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public List<Plant> completePlants(String query) {
		ArrayList<Plant> allPlants = new ArrayList<Plant>();
		
		// Create plants and add them to the collection.
		Plant redbud = new Plant();
		redbud.setName("Eastern Redbud");
		allPlants.add(redbud);
		
		Plant pawpaw = new Plant();
		pawpaw.setName("Paw Paw");
		allPlants.add(pawpaw);
		
		Plant nasturtium = new Plant();
		nasturtium.setName("nasturtium");
		allPlants.add(nasturtium);
		
		
		return allPlants;
	}


}
