package com.example.tubesPBW.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.tubesPBW.Data.Genre;
import com.example.tubesPBW.Repo.GenreRepository;

@Repository
public class JdbcGenreRepository implements GenreRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Genre> findAll() {
        String sql = "SELECT * FROM Genre";
        return jdbcTemplate.query(sql, this::mapRowToGenre);
    }

    private Genre mapRowToGenre(ResultSet resultSet, int rowNum) throws SQLException {
        return new Genre(
            resultSet.getInt("Genre_id"),                  // Ambil ID
            resultSet.getString("Genre")        // Ambil Username
        );
    }
}