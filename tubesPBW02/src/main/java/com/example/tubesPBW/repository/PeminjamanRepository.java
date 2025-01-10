//repositori ini untuk menangani database terkait peminjaman

package com.example.tubesPBW.repository;

import com.example.tubesPBW.model.Peminjaman;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peminjamanList;
    }
}




