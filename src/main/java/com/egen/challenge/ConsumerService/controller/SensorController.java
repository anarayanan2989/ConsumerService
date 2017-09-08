package com.egen.challenge.ConsumerService.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.egen.challenge.ConsumerService.SensorRepository;
import com.egen.challenge.ConsumerService.Weight;

import ch.qos.logback.classic.Level;

@RestController
@RequestMapping(value="/")
public class SensorController {

	@Autowired
	private SensorRepository sensor;
	
	@Autowired
	MongoOperations mongoOperations;
	
	protected Logger logger = Logger.getLogger(SensorController.class.getName());
	
	@GetMapping(path="/getWeights", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Weight> getAllWeights(){
		List<Weight> weight = sensor.findAll();
		return weight;
		
	}
	
	@PostMapping(path="/findRange", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Weight> findBytimeStamp(@RequestParam(required=true) String startTime, @RequestParam(required = true) String endTime){
		return sensor.findBytimeStamp(startTime, endTime);
	}
	
	/*@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(Weight obj ){
		if(mongoOperations.collectionExists(Weight.class)){
			mongoOperations.dropCollection(Weight.class);
		}
		Weight weight = new Weight();
		weight.setBase_weight(base_weight);
		
	}*/
	
	
	
}
