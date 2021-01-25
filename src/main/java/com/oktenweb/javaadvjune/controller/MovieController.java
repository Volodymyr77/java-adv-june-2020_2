package com.oktenweb.javaadvjune.controller;

import com.oktenweb.javaadvjune.dao.MovieRepository;
import com.oktenweb.javaadvjune.entity.Movie;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    private List<Movie> movies = new ArrayList<>();

    {

        movies.add(new Movie(1, "LoTR: BR", 187));
        movies.add(new Movie(2, "LoTR: TT", 179));
        movies.add(new Movie(3, "LoTR: RK", 193));
    }


    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getAllMovies() {

        return movieRepository.findAll();
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        movies.add(movie);
        return movieRepository.saveAndFlush(movie);
    }

    @PutMapping(value = "/{id")
    public Movie updateMovie(@PathVariable int id,  @RequestBody Movie movie) {
    final Optional<Movie> movieOptional = movieRepository.findById(id);
    if (movieOptional.isPresent()) {
        throw new IllegalArgumentException("No movie with such id: " +  id);
            }
       return movieRepository.saveAndFlush(movie);
    }

    @DeleteMapping(value = "/id")
        public void deleteMovie(@PathVariable int id) {
        movieRepository.deleteById(id);
    }

}
