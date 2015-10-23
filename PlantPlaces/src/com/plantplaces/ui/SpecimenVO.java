package com.plantplaces.ui;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Plant;
import com.plantplaces.dto.Specimen;
import com.plantplaces.service.IPlantService;

@Named
@ManagedBean
@Scope("session")
public class SpecimenVO {

	private Plant plant;
	
	@Inject
	private Specimen specimen;
	
	@Inject
	private IPlantService plantService;

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
		loadSpecimens();
	}

	private void loadSpecimens() {
		// TODO Auto-generated method stub
		plantService.loadSpecimens(plant);
	}

	public Specimen getSpecimen() {
		return specimen;
	}

	public void setSpecimen(Specimen specimen) {
		this.specimen = specimen;
	}

	public String save() {
		// set the foreign key to plant ID before saving.
		specimen.setPlantId(plant.getGuid());
		
		try {
			plantService.save(specimen);
			return "specimensaved";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";
		}
		
		
	}

	
}
