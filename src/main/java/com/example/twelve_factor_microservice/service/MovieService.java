package com.example.twelve_factor_microservice.service;

import com.example.twelve_factor_microservice.entity.Movie;
import com.example.twelve_factor_microservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private final MovieRepository movieRepository;

    MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<Movie> retrieveAllMovies() {
        return movieRepository.findAll();
    }

    public Movie retrieveMovie(Long id) {
        return movieRepository.findById(id).get();
    }

    public void save(Movie movie) {

        Optional<Movie> optionalMovie = movieRepository.findMovieByTitle(movie.getTitle());
        if(optionalMovie.isPresent()){
            throw new IllegalStateException("movie already in database");
        }
        movieRepository.save(movie);
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}
