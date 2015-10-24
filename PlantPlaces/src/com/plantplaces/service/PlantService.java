package com.plantplaces.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.plantplaces.dao.IFileDAO;
import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dao.ISpecimenDAO;
import com.plantplaces.dto.Photo;
import com.plantplaces.dto.Plant;
import com.plantplaces.dto.Specimen;

@Named
public class PlantService implements IPlantService {

	@Inject
	private	IPlantDAO plantDAO;
	
	@Inject
	private ISpecimenDAO specimenDAO;
	
	@Inject
	private IFileDAO fileDAO;
	
	
	private List<Plant> allPlants;
	
	@Override
	public List<Plant> filterPlants(String filter) {
		
		if (allPlants == null ) {
			allPlants = getPlantDAO().fetchPlants();
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
	
	public void save(Plant plant) throws Exception {
		if (plant.getGenus() == null || plant.getGenus().isEmpty()) {
			throw new Exception ("Genus required");
		}
		plantDAO.insert(plant);

	}
	

	@Override
	public List<Plant> fetchPlants(Plant plant) {
		List<Plant> plants = plantDAO.fetchPlants(plant);
		return plants;
	}

	public IPlantDAO getPlantDAO() {
		return plantDAO;
	}

	public void setPlantDAO(IPlantDAO plantDAO) {
		this.plantDAO = plantDAO;
	}

	@Override
	public void save(Specimen specimen) throws Exception {
		specimenDAO.insert(specimen);
	}

	@Override
	public void loadSpecimens(Plant plant) {
		// TODO Auto-generated method stub
		List<Specimen> specimens = specimenDAO.fetchByPlantId(plant.getGuid());
		plant.setSpecimens(specimens);
		
	}
	
	@Override
	public void savePhoto(Photo photo, InputStream inputStream) throws IOException {
		File directory = new File("/pictures");
		File file = new File(directory, "image.jpg");
		fileDAO.save(inputStream, file);
	}
	
}
