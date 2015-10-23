package com.plantplaces.dto;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;


@Named
@ManagedBean
@Scope("session")
public class Plant implements Serializable {
	
	private String name;
	private String genus;
	private String species;
	private String cultivar;
	private String common;
	private int guid;
	private List<Specimen> specimens;
	
	
	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getCultivar() {
		return cultivar;
	}

	public void setCultivar(String cultivar) {
		this.cultivar = cultivar;
	}

	public String getCommon() {
		return common;
	}

	public void setCommon(String common) {
		this.common = common;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return genus + "  " + species + " " + cultivar + " " + common;
	}

	public int getGuid() {
		return guid;
	}

	public void setGuid(int guid) {
		this.guid = guid;
	}

	public List<Specimen> getSpecimens() {
		return specimens;
	}

	public void setSpecimens(List<Specimen> specimens) {
		this.specimens = specimens;
	}
	

}
