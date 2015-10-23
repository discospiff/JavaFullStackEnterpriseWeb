package com.plantplaces.dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import com.plantplaces.dto.Specimen;

public interface ISpecimenDAO {

	void insert(Specimen specimen) throws Exception;

	List<Specimen> fetchByPlantId(int plantId);

}