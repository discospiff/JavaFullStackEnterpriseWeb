package com.plantplaces.dao;

import java.util.List;

import com.plantplaces.dto.Plant;

public interface IPlantDAO {
	
	public List<Plant> fetchPlants();
	
	public void insert(Plant plant) throws Exception;
	
	public void update (Plant plant) throws Exception;
	
	public void delete (Plant plant) throws Exception;

}
