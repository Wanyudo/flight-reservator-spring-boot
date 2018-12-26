package com.metaglobal.flights.flightreservatorspringboot.model.response;

import com.metaglobal.flights.flightreservatorspringboot.model.Links;

public class ReservableFlightResponse {

    private Long id;
    private Integer price;
    private String seatNumber;

    private Links links;

    public ReservableFlightResponse() {
        super();
    }

    public ReservableFlightResponse(Integer price, String seatNumber) {
        this.price = price;
        this.seatNumber = seatNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
