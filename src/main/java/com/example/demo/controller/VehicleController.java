package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;

@RestController
public class VehicleController {

	static final Logger LOG = LoggerFactory.getLogger(VehicleController.class);
	
	@Autowired
	private VehicleService vehicleService;
	
	/*---Add new vehicle---*/
	@PostMapping("/vehicle")
	public ResponseEntity<?> save(@RequestBody Vehicle vehicle) {
		long id = vehicleService.save(vehicle);
		return ResponseEntity.ok().body("New Vehicle has been saved with ID:" + id);
	}

	/*---Get a vehicle by id---*/
	@GetMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> get(@PathVariable("id") long id) {
		Vehicle vehicle = vehicleService.get(id);
		return ResponseEntity.ok().body(vehicle);
	}

	/*---get all vehicles---*/
	@GetMapping("/vehicle")
	public ResponseEntity<List<Vehicle>> list() {
		List<Vehicle> vehicles = vehicleService.list();
		return ResponseEntity.ok().body(vehicles);
	}

	/*---Update a vehicle by id---*/
	@PutMapping("/vehicle/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Vehicle vehicleReq) {
		
		Vehicle vehicle = vehicleService.get(id);
		
		if (vehicle.getId() > 0) {
	           
			vehicle.setType(vehicleReq.getType());
			vehicle.setMake(vehicleReq.getMake());
			vehicle.setModel(vehicleReq.getModel());
			vehicle.setYear(vehicleReq.getYear());
			
			long updatedVehicle = vehicleService.save(vehicle);

			return ResponseEntity.ok().body("Vehicle has been updated successfully.");
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/*---Delete a vehicle by id---*/
	@DeleteMapping("/vehicle/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		vehicleService.delete(id);
		return ResponseEntity.ok().body("Vehicle has been deleted successfully.");
	}
}