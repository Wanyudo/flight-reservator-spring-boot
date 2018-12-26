package com.metaglobal.flights.flightreservatorspringboot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Flight")
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String flightNumber;

    @NotNull
    private String price;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<ReservationEntity> reservationEntityList;

    public FlightEntity() {
    }

    public FlightEntity(@NotNull String flightNumber, @NotNull String price) {
        this.flightNumber = flightNumber;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<ReservationEntity> getReservationEntityList() {
        return reservationEntityList;
    }

    public void setReservationEntityList(List<ReservationEntity> reservationEntityList) {
        this.reservationEntityList = reservationEntityList;
    }

    public void addReservationEntity(ReservationEntity reservationEntity){
        if (reservationEntityList == null){
            reservationEntityList = new ArrayList<>();
        }
        reservationEntityList.add(reservationEntity);
    }
}
