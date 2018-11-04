package com.metaglobal.flights.flightreservatorspringboot.rest;

import com.metaglobal.flights.flightreservatorspringboot.model.request.ReservationRequest;
import com.metaglobal.flights.flightreservatorspringboot.model.response.ReservationResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(ResourceConstants.FLIGHT_RESERVATION_V1)
public class ReservationResource {

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservationResponse> getAvailableSeats(
            @RequestParam(value = "departurecountry") String departureCountry,
            @RequestParam(value = "destinationcountry") String destinationCountry,
            @RequestParam(value = "departuredate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departuredate){

        return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
    }

    @RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservationResponse> createReservation(
            @RequestBody
                    ReservationRequest reservationRequest) {

        return new ResponseEntity<>(new ReservationResponse(), HttpStatus.CREATED);
    }

    @RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservationResponse> updateReservation(
            @RequestBody
                    ReservationRequest reservationRequest) {

        return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{reservationid}/{reservationno}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> updateReservation(
            @PathVariable
            long reservationid) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
