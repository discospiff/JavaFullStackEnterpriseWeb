package com.plantplaces.ui;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Plant;
import com.plantplaces.service.IPlantService;

@Named
@ManagedBean
@Scope("session")
public class SearchPlants {


	@Inject
	private Plant plant;
	
	@Inject
	private IPlantService plantService;
	
	/**
	 * Handle button clicks from searches.
	 * @return the next navigation.
	 */
	public String execute() {

		int i = 1;
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
		return plantService.filterPlants(query);
	}


}
