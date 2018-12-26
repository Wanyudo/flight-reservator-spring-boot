package com.metaglobal.flights.flightreservatorspringboot.model.response;

import java.time.LocalDate;

public class ReservationResponse {
    private Long id;
    private LocalDate departureDate;
    private String destinationCountry;

    public ReservationResponse() {
        super();
    }

    public ReservationResponse(LocalDate departureDate, String destinationCountry) {
        this.departureDate = departureDate;
        this.destinationCountry = destinationCountry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }
}
