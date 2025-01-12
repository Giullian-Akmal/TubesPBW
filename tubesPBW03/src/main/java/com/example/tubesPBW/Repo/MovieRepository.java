/*package com.example.tubesPBW.Repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.tubesPBW.Data.Movie;

@Repository
public class MovieRepository {

    private final Connection connection;

    public MovieRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Movie> findAllMovies() {
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT m.movie_id, m.judul, g.nama_genre, m.status, m.stock, m.harga, a.nama_actor " +
                "FROM Movies m " +
                "JOIN Genre g ON m.genre_id = g.genre_id " +
                "JOIN Actors a ON m.movie_id = a.movie_id";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
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

    public List<Movie> searchFilms(String title, String genre, String actor) {
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT m.movie_id, m.judul, g.nama_genre, m.status, m.stock, m.harga, a.nama_actor " +
                "FROM Movies m " +
                "JOIN Genre g ON m.genre_id = g.genre_id " +
                "JOIN Actors a ON m.movie_id = a.movie_id " +
                "WHERE 1=1";

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
}*/

package com.example.tubesPBW.Repo;

import java.util.List;

import com.example.tubesPBW.Data.Movie;

public interface MovieRepository {
    List<Movie> findAll();
    List<Movie> searchFilms(String title, String genre, String actor);  // untuk mencari film berdasarkan filter
}

