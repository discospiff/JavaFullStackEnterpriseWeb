package com.plantplaces.ui;


import javax.annotation.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@ManagedBean
@Scope("session")
public class SearchPlants {


	public String execute() {

		return "noresults";
	}



}
