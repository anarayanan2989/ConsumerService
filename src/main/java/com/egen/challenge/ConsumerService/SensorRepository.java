package com.egen.challenge.ConsumerService;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends MongoRepository<Weight,String>{
	List<Weight> findByTimeRange(@Param("start") String startTime, @Param("end") String endTime);
}
