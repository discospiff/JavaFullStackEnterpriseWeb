package com.plantplaces.dto;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
public class Specimen {

	private int id;
	private int plantId;
	private String latitude;
	private String longitude;
	private String plantedBy;
	private String plantedDate;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlantId() {
		return plantId;
	}
	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getPlantedBy() {
		return plantedBy;
	}
	public void setPlantedBy(String plantedBy) {
		this.plantedBy = plantedBy;
	}
	public String getPlantedDate() {
		return plantedDate;
	}
	public void setPlantedDate(String plantedDate) {
		this.plantedDate = plantedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
