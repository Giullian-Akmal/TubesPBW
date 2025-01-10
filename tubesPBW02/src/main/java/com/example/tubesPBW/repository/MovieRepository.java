package com.example.tubesPBW.repository;

import com.example.tubesPBW.model.Movie;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {

    private final Connection connection;

    public MovieRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Movie> searchFilms(String title, String genre, String actor) {
        List<Movie> movies = new ArrayList<>();
        String query = """
                SELECT m.movie_id, m.judul, g.nama_genre, m.status, m.stock, m.harga, a.nama_actor
                FROM Movies m
                JOIN Genre g ON m.genre_id = g.genre_id
                JOIN Actors a ON m.movie_id = a.movie_id
                WHERE 1=1
                """;

        // Tambahkan filter berdasarkan input pengguna
        if (title != null && !title.isEmpty()) {
            query += " AND LOWER(m.judul) LIKE ?";
        }
        if (genre != null && !genre.isEmpty()) {
            query += " AND LOWER(g.nama_genre) LIKE ?";
        }
        if (actor != null && !actor.isEmpty()) {
            query += " AND LOWER(a.nama_actor) LIKE ?";
        }

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            int index = 1;

            if (title != null && !title.isEmpty()) {
                statement.setString(index++, "%" + title.toLowerCase() + "%");
            }
            if (genre != null && !genre.isEmpty()) {
                statement.setString(index++, "%" + genre.toLowerCase() + "%");
            }
            if (actor != null && !actor.isEmpty()) {
                statement.setString(index++, "%" + actor.toLowerCase() + "%");
            }

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt("movie_id"));
                movie.setTitle(resultSet.getString("judul"));
                movie.setGenre(resultSet.getString("nama_genre"));
                movie.setStatus(resultSet.getString("status"));
                movie.setStock(resultSet.getInt("stock"));
                movie.setHarga(resultSet.getInt("harga"));
                movie.setActor(resultSet.getString("nama_actor"));
                movies.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return movies;
    }
}
