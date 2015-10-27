package com.plantplaces.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.plantplaces.dto.Photo;
import com.plantplaces.dto.Plant;
import com.plantplaces.dto.Specimen;

/**
 * IPlantService includes all business related functions for a Plant and related entities
 * @author Brandan Jones
 *
 */
public interface IPlantService {

	/**
	 * Return a collection of Plant objects that contain the given filter text.
	 * @param filter a substring that should be contained in returned plants.
	 * @return a collection of matching plants.
	 */
	public List<Plant> filterPlants(String filter);

	/**
	 * Save the plant and perform a validation check.
	 * @param plant the plant we are persisting
	 * @throws Exception if unable to save
	 */
	void save(Plant plant) throws Exception;

	/**
	 *  Return a list of plants that match the given search criteria
	 * @param plant a parameter that contains the search criteria
	 * @return a list of matching plants
	 */
	List<Plant> fetchPlants(Plant plant);

	void save(Specimen specimen) throws Exception;

	/**
	 * Load specimens for a given plant.
	 * @param plant
	 */
	public void loadSpecimens(Plant plant);

	void savePhoto(Photo photo, InputStream inputStream) throws Exception;

	List<Photo> fetchPhotos(Specimen specimen);
	
}
