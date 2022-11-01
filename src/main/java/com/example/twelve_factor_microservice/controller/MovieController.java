package com.example.twelve_factor_microservice.controller;

import com.example.twelve_factor_microservice.entity.Movie;
import com.example.twelve_factor_microservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class MovieController {

    Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/movies")
    public List<Movie> retrieveAllMovies() {
        LOGGER.info("Retrieve all movies!");
        return movieService.retrieveAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie retrieveMovie(@PathVariable Long id) {
        LOGGER.info("Movie with id " + id + "is getting retrieved!");
        return movieService.retrieveMovie(id);
    }

    @PostMapping("/movies")
    public void createMovie(@RequestBody Movie movie) {
        LOGGER.info("Movie " + movie.toString() + "will be added!");
        movieService.save(movie);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMovie(@PathVariable Long id){
        LOGGER.info("Movie with id " + id + "will be deleted!");
        movieService.delete(id);
    }
}