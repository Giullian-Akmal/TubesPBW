package com.example.tubesPBW.controller;

import com.example.tubesPBW.model.Film;
import com.example.tubesPBW.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies/search")
    public List<Movie> searchFilms(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) String actor) {
        return movieRepository.searchFilms(title, genre, actor);
    }
}
