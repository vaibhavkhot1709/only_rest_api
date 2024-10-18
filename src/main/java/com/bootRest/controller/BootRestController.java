package com.bootRest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootRest.entity.Vehicle;

@RestController
@RequestMapping("vehicleRest")
public class BootRestController {

	
	@GetMapping("health")
	public String healthCheck() {
		return "up";
	}
	
	Map<Integer, Vehicle> vehicleEntreis=new HashMap<>();
	
	@GetMapping("vehicle")
	public List<Vehicle> getAll(){
		return new ArrayList<>(vehicleEntreis.values());
	}
	
	@PostMapping("vehicle")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicleEntry ){
		
		vehicleEntreis.put(vehicleEntry.getId(), vehicleEntry);
		return new ResponseEntity<Vehicle>(vehicleEntry, HttpStatus.CREATED);
	}
	
//	@GetMapping("vehicle/{vehicleId}")
//	public Vehicle findById(@PathVariable Integer vehicleId) {
//		return vehicleEntreis.get(vehicleId);
//	}
	
	@GetMapping("vehicle/{vehicleId}")
	public ResponseEntity<Vehicle> findById(@PathVariable Integer vehicleId) {
		
		if(vehicleId<=0) {
			return new ResponseEntity<Vehicle>(HttpStatus.BAD_REQUEST);
		}
		
		 Vehicle v1= vehicleEntreis.get(vehicleId);
		 
		 if(v1 == null) {
			 return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Vehicle>(v1, HttpStatus.OK);
	}
	
	@DeleteMapping("vehicle/{vehicleId}")
	public ResponseEntity<Vehicle> deleteById(@PathVariable Integer vehicleId) {
		
		if(vehicleId<=0) {
			return new ResponseEntity<Vehicle>(HttpStatus.BAD_REQUEST);
		}
		Vehicle v1= vehicleEntreis.get(vehicleId);
		if(v1 == null) {
			 return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
		 }
		
		
		vehicleEntreis.remove(vehicleId);
		return new ResponseEntity<Vehicle>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("vehicle/{vehicleId}") 
	public ResponseEntity<Vehicle> updateById(@PathVariable Integer vehicleId, @RequestBody Vehicle vehicleEntry) throws Exception{
		
		if(vehicleId<=0) {
			return new ResponseEntity<Vehicle>(HttpStatus.BAD_REQUEST);
		}
		
		 vehicleEntreis.put(vehicleId, vehicleEntry);
		 return new ResponseEntity<Vehicle>(HttpStatus.OK);
	}
}

