package com.plantplaces.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import com.plantplaces.dto.Plant;

public class PlantHbmDAO implements IPlantDAO {

	@Override
	public List<Plant> fetchPlants() {

		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Plant> fetchPlants(Plant plant) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		// create the query
		org.hibernate.Query query = session.createQuery("from Plant where common = :common");
		// query.setParameter("common", plant.getCommon());
		query.setProperties(plant);
		@SuppressWarnings("rawtypes")
		List list = query.list();
		
		List<Plant> plants = Collections.checkedList(list, Plant.class);
		
		return plants;
	}

	@Override
	public void insert(Plant plant) throws Exception {
		// save the plant to the database.
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(plant);
		
		session.getTransaction().commit();

	}

	@Override
	public void update(Plant plant) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Plant plant) throws Exception {
		// TODO Auto-generated method stub

	}

}
