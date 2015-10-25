package com.plantplaces.dao;

import org.hibernate.Session;

public abstract class PlantPlacesHbmDAO<T> {
	
	/**
	 * Create a hibernate session and atomic unit; make it available to the subclass for persistence
	 * @param dto
	 * @throws Exception
	 */
	public void save(T dto) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		insert(session, dto);
		
		session.getTransaction().commit();
	}
	
	/**
	 * Allow the subclass to determine how to save this item.
	 * @param session
	 * @param dto
	 */
	public abstract void insert(Session session, T dto) throws Exception; 

}
