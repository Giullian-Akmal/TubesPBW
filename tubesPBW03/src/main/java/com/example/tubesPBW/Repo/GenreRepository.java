package com.example.tubesPBW.Repo;

import java.util.List;

import com.example.tubesPBW.Data.Genre;

public interface GenreRepository {
    List<Genre> findAll();
}
