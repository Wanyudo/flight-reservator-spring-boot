package com.metaglobal.flights.flightreservatorspringboot.repository;

import com.metaglobal.flights.flightreservatorspringboot.entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {

}
