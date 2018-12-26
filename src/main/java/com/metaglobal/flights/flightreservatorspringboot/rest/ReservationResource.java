package com.metaglobal.flights.flightreservatorspringboot.rest;

import com.metaglobal.flights.flightreservatorspringboot.converter.FlightEntityToReservableFlightResponseConverter;
import com.metaglobal.flights.flightreservatorspringboot.entity.FlightEntity;
import com.metaglobal.flights.flightreservatorspringboot.entity.ReservationEntity;
import com.metaglobal.flights.flightreservatorspringboot.model.request.ReservationRequest;
import com.metaglobal.flights.flightreservatorspringboot.model.response.ReservableFlightResponse;
import com.metaglobal.flights.flightreservatorspringboot.model.response.ReservationResponse;
import com.metaglobal.flights.flightreservatorspringboot.repository.FlightRepository;
import com.metaglobal.flights.flightreservatorspringboot.repository.PageableFlightRepository;
import com.metaglobal.flights.flightreservatorspringboot.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(ResourceConstants.FLIGHT_RESERVATION_V1)
public class ReservationResource {

    @Autowired
    PageableFlightRepository pageableFlightRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ConversionService conversionService;

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<ReservableFlightResponse> getAvailableSeats(
            @RequestParam(value = "departurecountry") String departureCountry,
            @RequestParam(value = "destinationcountry") String destinationCountry,
            @RequestParam(value = "departuredate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departuredate,
            Pageable pageable
            ){

        Page<FlightEntity> flightEntityList = pageableFlightRepository.findAll(pageable);

        return flightEntityList.map(new FlightEntityToReservableFlightResponseConverter());
    }

    @RequestMapping(path = "/{flightId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<FlightEntity> getFlightById(
            @PathVariable
            Long flightId){
        FlightEntity flightEntity = flightRepository.findById(flightId);
        return new ResponseEntity<>(flightEntity, HttpStatus.OK);
    }

    @RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservationResponse> createReservation(
            @RequestBody
                    ReservationRequest reservationRequest) {

        ReservationEntity reservationEntity = conversionService.convert(reservationRequest, ReservationEntity.class);
        reservationRepository.save(reservationEntity);

        FlightEntity flightEntity = flightRepository.findById(reservationRequest.getId());
        flightEntity.addReservationEntity(reservationEntity);
        flightRepository.save(flightEntity);
        reservationEntity.setFlightEntity(flightEntity);

        ReservationResponse reservationResponse = conversionService.convert(reservationEntity, ReservationResponse.class);

        return new ResponseEntity<>(reservationResponse, HttpStatus.CREATED);
    }

    @RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservableFlightResponse> updateReservation(
            @RequestBody
                    ReservationRequest reservationRequest) {

        return new ResponseEntity<>(new ReservableFlightResponse(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{reservationid}/{reservationno}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> updateReservation(
            @PathVariable
            long reservationid) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
