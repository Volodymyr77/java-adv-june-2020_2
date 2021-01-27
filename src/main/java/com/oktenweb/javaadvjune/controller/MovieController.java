package com.oktenweb.javaadvjune.controller;

import com.oktenweb.javaadvjune.dao.MovieRepository;
import com.oktenweb.javaadvjune.entity.Movie;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//@Component
//@Bean
//@Controller
//@Repository
//@Service
//@Configuration
//@Value

@RestController
@RequestMapping(value = "/movies")

public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

//    private List<Movie> movies = new ArrayList<>();
//
//    {
//
//        movies.add(new Movie(1, "LoTR: BR", 187));
//        movies.add(new Movie(2, "LoTR: TT", 179));
//        movies.add(new Movie(3, "LoTR: RK", 193));
//    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.saveAndFlush(movie);
    }

    @PutMapping(value = "/{id")
    public Movie updateMovie(@PathVariable int id,  @RequestBody Movie movie) {
    final Optional<Movie> movieOptional = movieRepository.findById(id);
    if (movieOptional.isPresent()) {
        throw new IllegalArgumentException("No movie with such id: " +  id);
            }
    movie.setId(id);
       return movieRepository.saveAndFlush(movie);
    }

    @DeleteMapping(value = "/id")
        public void deleteMovie(@PathVariable int id) {
        movieRepository.deleteById(id);
    }

}
