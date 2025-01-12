package com.example.tubesPBW.Repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.tubesPBW.Data.Peminjaman;

@Repository
public class PeminjamanRepository {

    private final Connection connection;

    public PeminjamanRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Peminjaman> findByUserId(int userId) {
        List<Peminjaman> peminjamanList = new ArrayList<>();
        String query = "SELECT * FROM peminjaman WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Peminjaman peminjaman = new Peminjaman();
                peminjaman.setPeminjamanId(resultSet.getInt("id"));
                peminjaman.setUserId(resultSet.getInt("user_id"));
                peminjaman.setMovieId(resultSet.getInt("movie_id"));
                peminjaman.setTanggalPinjam(resultSet.getString("tanggal_pinjam"));
                peminjaman.setTanggalKembali(resultSet.getString("tanggal_kembali"));
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
