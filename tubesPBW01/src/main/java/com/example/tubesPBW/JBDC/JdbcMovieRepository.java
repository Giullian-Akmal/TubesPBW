package com.example.tubesPBW.JBDC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.tubesPBW.Data.Movie;
import com.example.tubesPBW.Repo.MovieRepository;

@Repository
public class JdbcMovieRepository implements MovieRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> findAll() {
        String sql = "SELECT * FROM Movies";
        return jdbcTemplate.query(sql, this::mapRowToGenre);
    }

    private Movie mapRowToGenre(ResultSet resultSet, int rowNum) throws SQLException {
        return new Movie(
            resultSet.getInt("movie_id"),                  // Ambil ID
            resultSet.getString("judul"),       // Ambil Username
            resultSet.getString("genre"),
            resultSet.getString("aktor")
        );
    }
}