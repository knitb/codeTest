package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Vehicle;

public interface VehicleService {
	
	long save(Vehicle vehicle);

	Vehicle get(long id);

	List<Vehicle> list();

	void delete(long id);

	void update(Vehicle vehicle);
	
}
