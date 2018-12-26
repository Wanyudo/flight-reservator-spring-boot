package com.metaglobal.flights.flightreservatorspringboot.converter;

import com.metaglobal.flights.flightreservatorspringboot.entity.ReservationEntity;
import com.metaglobal.flights.flightreservatorspringboot.model.response.ReservationResponse;
import org.springframework.core.convert.converter.Converter;

public class ReservationEntityToReservationResponseConverter implements Converter<ReservationEntity, ReservationResponse> {

    @Override
    public ReservationResponse convert(ReservationEntity source) {
        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setDepartureDate(source.getDepartureDate());
        reservationResponse.setDestinationCountry(source.getDestinationCountry());
        return reservationResponse;
    }
}
