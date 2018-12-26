package com.metaglobal.flights.flightreservatorspringboot.converter;

import com.metaglobal.flights.flightreservatorspringboot.entity.ReservationEntity;
import com.metaglobal.flights.flightreservatorspringboot.model.request.ReservationRequest;
import org.springframework.core.convert.converter.Converter;

public class ReservationRequestToReservationEntityConverter implements Converter<ReservationRequest, ReservationEntity> {

    @Override
    public ReservationEntity convert(ReservationRequest source) {
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setDepartureDate(source.getDeparturedate());
        reservationEntity.setDestinationCountry(source.getDestinationcountry());

        if (source.getId() != null){
            reservationEntity.setId(source.getId());
        }

        return reservationEntity;
    }
}
