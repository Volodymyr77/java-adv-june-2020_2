package com.oktenweb.javaadvjune.controller;

import com.oktenweb.javaadvjune.entity.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MovieController {

    private List<Movie> movies = Arrays.asList(new Movie(1, "LoTR: BR", 187),
            new Movie(2, "LoTR: TT", 179),
            new Movie(3, "LoTR: RK", 193)
            );

    @GetMapping(value = "/movies")
    public List<Movie> getAllMovies() {
return movies;
    }
}
