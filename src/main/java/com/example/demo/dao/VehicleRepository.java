package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Vehicle;

@RepositoryRestResource
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	Vehicle findById(long id);
	
	List<Vehicle> findByType(String type);
	
	List<Vehicle> findByMake(String make);
	
	List<Vehicle> findByModel(String model);
	
	List<Vehicle> findByYear(String year);
}
