package com.oktenweb.javaadvjune.controller;

import com.oktenweb.javaadvjune.dao.MovieRepository;
import com.oktenweb.javaadvjune.entity.Movie;
import com.oktenweb.javaadvjune.service.IMovieService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
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

    @Autowired
    private IMovieService movieService;

//    public MovieController(MovieRepository movieRepository) {
//        this.movieRepository = movieRepository;
//    }

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
        return movieService.getAllMovies();
    }

    @GetMapping("/movie")
    public Movie getMovie(@RequestParam int id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie createMovie(@RequestBody @Valid Movie movie) {
                return movieService.saveMovie(movie);
    }

    @PutMapping(value = "/{id")
    public Movie updateMovie(@PathVariable int id,  @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping(value = "/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteMovie(@PathVariable int id) {
            movieService.deleteMovie(id);
    }
}
