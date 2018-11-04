package com.metaglobal.flights.flightreservatorspringboot.model.request;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ReservationRequest {

    private Long id;
    private String destinationcountry;
    private String departurecountry;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate departuredate;

    public ReservationRequest() {
        super();
    }

    public ReservationRequest(Long id, LocalDate departuredate, String departurecountry, String destinationcountry) {
        super();
        this.id = id;
        this.departuredate = departuredate;
        this.departurecountry = departurecountry;
        this.destinationcountry = destinationcountry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(LocalDate departuredate) {
        this.departuredate = departuredate;
    }

    public String getDeparturecountry() {
        return departurecountry;
    }

    public void setDeparturecountry(String departurecountry) {
        this.departurecountry = departurecountry;
    }

    public String getDestinationcountry() {
        return destinationcountry;
    }

    public void setDestinationcountry(String destinationcountry) {
        this.destinationcountry = destinationcountry;
    }
}
