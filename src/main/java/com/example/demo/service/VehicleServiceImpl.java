package com.example.demo.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.VehicleRepository;
import com.example.demo.model.Vehicle;

@Service
@Transactional(readOnly = true)
public class VehicleServiceImpl implements VehicleService {

	static final Logger LOG = LoggerFactory.getLogger(VehicleServiceImpl.class);
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Transactional
	@Override
	public long save(Vehicle vehicle) {
		vehicle = vehicleRepository.save(vehicle);
		return vehicle.getId();
	}

	@Override
	public Vehicle get(long id) {
		return vehicleRepository.findById(id);
	}

	@Override
	public List<Vehicle> list() {
		return vehicleRepository.findAll();
	}

	@Transactional
	@Override
	public void update(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}

	@Override
	public void delete(long id) {
		vehicleRepository.deleteById(id);
	}
}
