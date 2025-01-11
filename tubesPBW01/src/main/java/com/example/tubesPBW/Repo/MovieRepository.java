package com.example.tubesPBW.Repo;

import java.util.List;

import com.example.tubesPBW.Data.Movie;

public interface MovieRepository {
    List<Movie> findAll();
}
