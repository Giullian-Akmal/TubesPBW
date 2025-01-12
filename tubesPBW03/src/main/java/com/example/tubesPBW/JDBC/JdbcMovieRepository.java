/*package com.example.tubesPBW.JDBC;

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
}*/

package com.example.tubesPBW.JDBC;

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
        return jdbcTemplate.query(sql, this::mapRowToMovie);
    }

    @Override
    public List<Movie> searchFilms(String title, String genre, String actor) {
        StringBuilder sql = new StringBuilder("SELECT * FROM Movies WHERE 1=1");

        if (title != null && !title.isEmpty()) {
            sql.append(" AND judul LIKE ?");
        }
        if (genre != null && !genre.isEmpty()) {
            sql.append(" AND genre LIKE ?");
        }
        if (actor != null && !actor.isEmpty()) {
            sql.append(" AND aktor LIKE ?");
        }

        return jdbcTemplate.query(sql.toString(),
            preparedStatement -> {
                int paramIndex = 1;
                if (title != null && !title.isEmpty()) {
                    preparedStatement.setString(paramIndex++, "%" + title + "%");
                }
                if (genre != null && !genre.isEmpty()) {
                    preparedStatement.setString(paramIndex++, "%" + genre + "%");
                }
                if (actor != null && !actor.isEmpty()) {
                    preparedStatement.setString(paramIndex++, "%" + actor + "%");
                }
            },
            this::mapRowToMovie
        );
    }

    private Movie mapRowToMovie(ResultSet resultSet, int rowNum) throws SQLException {
        return new Movie(
            resultSet.getInt("movie_id"),
            resultSet.getString("judul"),
            resultSet.getString("genre"),
            resultSet.getString("aktor")
        );
    }
}
