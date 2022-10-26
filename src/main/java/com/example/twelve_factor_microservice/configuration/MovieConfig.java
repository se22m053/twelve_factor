package com.example.twelve_factor_microservice.configuration;

import com.example.twelve_factor_microservice.entity.Movie;
import com.example.twelve_factor_microservice.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MovieConfig {

    @Bean
    CommandLineRunner commandLineRunner(MovieRepository movieRepository) {
        return args -> {
            Movie avengers = new Movie( "Marvel's the Avengers", "2012", "4,3");
            Movie harry_potter = new Movie( "Harry Potter und der Stein der Weisen", "2012", "4,0");

            movieRepository.saveAll(List.of(avengers, harry_potter));
        };
    }
}
