package com.metaglobal.flights.flightreservatorspringboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.metaglobal.flights.flightreservatorspringboot.entity.FlightEntity;

public interface PageableFlightRepository extends PagingAndSortingRepository<FlightEntity, Long> {
    Page<FlightEntity> findById(Long id, Pageable page);
}
