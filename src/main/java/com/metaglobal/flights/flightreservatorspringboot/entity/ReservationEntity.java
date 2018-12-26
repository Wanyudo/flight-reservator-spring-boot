package com.metaglobal.flights.flightreservatorspringboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "Reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private LocalDate departureDate;

    @NotNull
    private String destinationCountry;

    @NotNull
    private String departureCountry;

    @ManyToOne
    private FlightEntity flightEntity;

    public ReservationEntity() {
        super();
    }

    public ReservationEntity(LocalDate departureDate, String destinationCountry, String departureCountry) {
        this.departureDate = departureDate;
        this.destinationCountry = destinationCountry;
        this.departureCountry = departureCountry;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public void setDepartureCountry(String departureCountry) {
        this.departureCountry = departureCountry;
    }

    public FlightEntity getFlightEntity() {
        return flightEntity;
    }

    public void setFlightEntity(FlightEntity flightEntity) {
        this.flightEntity = flightEntity;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
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

}
