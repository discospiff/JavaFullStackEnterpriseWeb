package com.plantplaces.dao;

import javax.inject.Named;

import org.hibernate.Session;

import com.plantplaces.dto.Photo;

@Named
public class PhotoHbmDAO extends PlantPlacesHbmDAO<Photo> implements IPhotoDAO {

	
	@Override
	public void insert(Session session, Photo dto) throws Exception {
		// TODO Auto-generated method stub
		session.save(dto);
	}

}
