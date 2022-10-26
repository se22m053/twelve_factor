package com.example.twelve_factor_microservice.controller;

import com.example.twelve_factor_microservice.entity.Movie;
import com.example.twelve_factor_microservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/movies")
    public List<Movie> retrieveAllMovies() {
        return movieService.retrieveAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie retrieveMovie(@PathVariable Long id) {
        return movieService.retrieveMovie(id);
    }

    @PostMapping("/movies")
    public void createMovie(@RequestBody Movie movie) {
        movieService.save(movie);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMovie(@PathVariable Long id){
        movieService.delete(id);
    }
}