package com.plantplaces.ui;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.plantplaces.dto.Plant;
import com.plantplaces.service.IPlantService;

@WebService
@Named
public class PlantWSService implements IPlantWSSerice/*, ApplicationContextAware*/ {

	@Inject
	private
	IPlantService plantService;
	
	
	public PlantWSService() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	/* (non-Javadoc)
	 * @see com.plantplaces.ui.IPlantWSSerice#fetchPlants(java.lang.String)
	 */
	@Override
	@WebMethod
	public String fetchPlants(String plantName) {
		// a default value, in case no plants match.
		String returnValue =  "No plants match your search.";
		
		// our search criteria.
		Plant searchPlant = new Plant();
		searchPlant.setCommon(plantName);
		 
		// get a list of plants that match the result
		List<Plant> plants = getPlantService().fetchPlants(searchPlant);

		// iterate over the results, and just pick the last one and return it.
		for (Plant plant : plants) {
			returnValue = plant.toString();
		}
		
		
		return returnValue;
		
	}


	public IPlantService getPlantService() {
		return plantService;
	}


	public void setPlantService(IPlantService plantService) {
		this.plantService = plantService;
	}

}
