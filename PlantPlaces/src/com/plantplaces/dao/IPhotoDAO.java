package com.plantplaces.dao;

import java.util.List;

import org.hibernate.Session;

import com.plantplaces.dto.Photo;
import com.plantplaces.dto.Specimen;

public interface IPhotoDAO {

	void insert(Session session, Photo dto) throws Exception;
	public void save(Photo dto) throws Exception;
	List<Photo> fetchPhotos(Specimen specimen);

}