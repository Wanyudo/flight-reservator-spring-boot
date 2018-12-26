package com.metaglobal.flights.flightreservatorspringboot.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.metaglobal.flights.flightreservatorspringboot.repository")
@EnableTransactionManagement
public class DatabaseConfig {
}
