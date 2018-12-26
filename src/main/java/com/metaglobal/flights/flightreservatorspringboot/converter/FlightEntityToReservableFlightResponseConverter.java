package com.metaglobal.flights.flightreservatorspringboot.converter;

import org.springframework.core.convert.converter.Converter;

import com.metaglobal.flights.flightreservatorspringboot.entity.FlightEntity;
import com.metaglobal.flights.flightreservatorspringboot.model.Links;
import com.metaglobal.flights.flightreservatorspringboot.model.Self;
import com.metaglobal.flights.flightreservatorspringboot.model.response.ReservableFlightResponse;
import com.metaglobal.flights.flightreservatorspringboot.rest.ResourceConstants;

public class FlightEntityToReservableFlightResponseConverter implements Converter<FlightEntity, ReservableFlightResponse> {

    @Override
    public ReservableFlightResponse convert(FlightEntity source) {
        ReservableFlightResponse reservableFlightResponse = new ReservableFlightResponse();
        reservableFlightResponse.setSeatNumber(source.getFlightNumber());
        reservableFlightResponse.setPrice( Integer.valueOf(source.getPrice()) );

        Links links = new Links();
        Self self = new Self();
        self.setRef(ResourceConstants.FLIGHT_RESERVATION_V1 + "/" + source.getId());
        links.setSelf(self);

        reservableFlightResponse.setLinks(links);
        return reservableFlightResponse;
    }
}
