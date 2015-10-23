package com.plantplaces.dao;

import java.util.Collections;
import java.util.List;

import javax.inject.Named;

import org.hibernate.Session;

import com.plantplaces.dto.Specimen;

/**
 * A Hibernate persistence implementation of our specimen DAO.
 * @author Win7
 *
 */
@Named
public class SpecimenHbmDAO implements ISpecimenDAO {
	
	/* (non-Javadoc)
	 * @see com.plantplaces.dao.ISpecimenDAO#insert(com.plantplaces.dto.Specimen)
	 */
	@Override
	public void insert(Specimen specimen) throws Exception {
		// save the plant to the database.
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(specimen);
		
		session.getTransaction().commit();
	}
	
	@Override
	public List<Specimen> fetchByPlantId(int plantId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		// create the query
		org.hibernate.Query query = session.createQuery("from Specimen where plantId = :plantId");
		query.setParameter("plantId", plantId);
		// query.setProperties(plant);
		@SuppressWarnings("rawtypes")
		List list = query.list();
		
		List<Specimen> specimens = Collections.checkedList(list, Specimen.class);
		
		return specimens;
	}

}
