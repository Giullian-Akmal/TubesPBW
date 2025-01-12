package com.example.tubesPBW.Repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.tubesPBW.Data.Genre;
import com.example.tubesPBW.Data.Peminjaman;

@Repository
public class PeminjamanRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final Connection connection;

    public PeminjamanRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Peminjaman> findAll() {
        String sql = "SELECT * FROM Peminjaman";
        return jdbcTemplate.query(sql, this::mapRowToPeminjaman);
    }

    private Peminjaman mapRowToPeminjaman(ResultSet resultSet, int rowNum) throws SQLException {
        return new Peminjaman(
            resultSet.getInt("Peminjaman_id"),             
            resultSet.getString("judulfilm"),
            resultSet.getInt("durasi")       
        );
    }

    public List<Peminjaman> findByUserId(int userId) {
        List<Peminjaman> peminjamanList = new ArrayList<>();
        String query = "SELECT * FROM peminjaman WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Peminjaman peminjaman = new Peminjaman(userId, query, userId);
                peminjamanList.add(peminjaman);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return peminjamanList;
    }

    public void addPeminjaman(int userId, int movieId, int lamaPeminjaman) {
        String query = "INSERT INTO peminjaman (user_id, movie_id, tanggal_pinjam, tanggal_kembali) VALUES (?, ?, CURRENT_DATE, DATE_ADD(CURRENT_DATE, INTERVAL ? DAY))";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.setInt(2, movieId);
            statement.setInt(3, lamaPeminjaman);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
