package com.metaglobal.flights.flightreservatorspringboot;

import com.metaglobal.flights.flightreservatorspringboot.entity.FlightEntity;
import com.metaglobal.flights.flightreservatorspringboot.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class H2Bootstrap implements CommandLineRunner {

    @Autowired
    FlightRepository flightRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Bootstrapping data: ");

        flightRepository.save(new FlightEntity("1L_90B", "145"));
        flightRepository.save(new FlightEntity("1L_91B", "150"));
        flightRepository.save(new FlightEntity("1L_92B", "155"));
        flightRepository.save(new FlightEntity("1L_93B", "160"));

        Iterable<FlightEntity> itr = flightRepository.findAll();

        System.out.println("Printing out data: ");
        for(FlightEntity flightEntity : itr){
            System.out.println(flightEntity.getFlightNumber());
        }
    }
}
