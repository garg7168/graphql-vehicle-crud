package com.alti.graphql.service;

import com.alti.graphql.dao.entity.UpdateVehicleInput;
import com.alti.graphql.dao.entity.Vehicle;
import com.alti.graphql.dao.repository.VehicleRepository;
import com.alti.graphql.exceptions.VehicleNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository ;

    public VehicleService(final VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository ;
    }

    @Transactional
    public Vehicle createVehicle(final String type,final String modelCode, final String brandName, final String launchDate) {
        final Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        return this.vehicleRepository.save(vehicle);
    }

    @Transactional(readOnly = true)
    public List<Vehicle> getAllVehicles(final int count) {
        return this.vehicleRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleRepository.findById(id);
    }

      //@Transactional
	  public int deleteById(final int id) {
		  System.out.println("id is " +id);
		  this.vehicleRepository.deleteById(id);
		  return id; 
	  }  
	/*
	 * @Transactional(readOnly = true) public List<Vehicle> getAllVehicles() {
	 * return this.vehicleRepository.findAll(); }
	 */
	  
	  @Transactional
	    public Vehicle updateVeh(UpdateVehicleInput input) {
		  Vehicle vehicle = vehicleRepository.getOne(input.getId());//.orElseThrow(VehicleNotFoundException::new);
		  vehicle.setType(input.getType());
		  vehicle.setModelCode(input.getModelCode());
		    return vehicle;
	    }
	  
	 
	  
}
