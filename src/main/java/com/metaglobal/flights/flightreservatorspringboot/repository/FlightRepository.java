package com.metaglobal.flights.flightreservatorspringboot.repository;

import com.metaglobal.flights.flightreservatorspringboot.entity.FlightEntity;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<FlightEntity, Long> {

    FlightEntity findById(Long Id);
}
