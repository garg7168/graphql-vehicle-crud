package com.alti.graphql.mutation;

import com.alti.graphql.dao.entity.UpdateVehicleInput;
import com.alti.graphql.dao.entity.Vehicle;
import com.alti.graphql.service.VehicleService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
public class VehicleMutation implements GraphQLMutationResolver {

	@Autowired
	private VehicleService vehicleService;

	public Vehicle createVehicle(final String type, final String modelCode, final String brandName,
			final String launchDate) {
		return this.vehicleService.createVehicle(type, modelCode, brandName, launchDate);
	}

	
	  public int deleteVehicle(final int id) {
		  return this.vehicleService.deleteById(id);
	  }
	  
	    public Vehicle updateVehicle(UpdateVehicleInput input) {
	        return vehicleService.updateVeh(input);
	    }
}
