package com.plantplaces.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.plantplaces.dto.Plant;
import com.plantplaces.service.IPlantService;

@Named
public class PlantJSONServlet extends HttpServlet {
	
	@Inject
	private	IPlantService plantService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		// this sets up our dependency injection.
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// our search criteria.
		Plant searchPlant = new Plant();
		searchPlant.setCommon("e");
		 
		// get a list of plants that match the result
		List<Plant> plants = getPlantService().fetchPlants(searchPlant);
		
		
		// start writing a stream of data.
		resp.setContentType("application/json");
		PrintWriter writer = resp.getWriter();
		
		// start building a JSON tree.
		JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
		
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		
		
		for (Plant plant : plants) {
			// create a JSON object for each plant.  The plants will have the same names, but different values.
			JsonObjectBuilder plantBuilder = Json.createObjectBuilder();
			JsonObject plantJson = plantBuilder.add("genus", plant.getGenus() != null ? plant.getGenus() : "")
			.add("species", plant.getSpecies() != null ? plant.getSpecies() : "")
			.add("common", plant.getCommon() != null ? plant.getCommon() : "")
			.add("cultivar", plant.getCultivar() != null ? plant.getCultivar() : "")
			.build();
			
			// add the plant to our array of plants.
			arrayBuilder.add(plantJson);
		}
		
		// add the array of plants to a root JSON object.
		JsonObject root = rootBuilder.add("plants", arrayBuilder).build();
		
		
		// write the JSON to our servlet, which is accessed by a URL.
		writer.print(root);
		
		// flush the bytes and close the stream.
		writer.flush();
		writer.close();
	
	
	}

	public IPlantService getPlantService() {
		return plantService;
	}

	public void setPlantService(IPlantService plantService) {
		this.plantService = plantService;
	}

}
