//repositori ini untuk menangani database terkait pelanggan

package com.example.tubesPBW.repository;

import com.example.tubesPBW.model.Pelanggan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PelangganRepository {

    private final JdbcTemplate jdbcTemplate;

    public PelangganRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Menyimpan data pelanggan baru
    public void save(Pelanggan pelanggan) {
        String sql = "INSERT INTO Pengguna (username, password, email, role, nama, no_telp, birthdate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, pelanggan.getUsername(), pelanggan.getPassword(), pelanggan.getEmail(), pelanggan.getRole(),
                pelanggan.getNama(), pelanggan.getNoTelp(), pelanggan.getBirthdate());
    }

    // Mengambil data pelanggan berdasarkan id
    public Pelanggan findById(int userId) {
        String sql = "SELECT * FROM Pengguna WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Pelanggan pelanggan = new Pelanggan();
            pelanggan.setUserId(rs.getInt("user_id"));
            pelanggan.setUsername(rs.getString("username"));
            pelanggan.setPassword(rs.getString("password"));
            pelanggan.setEmail(rs.getString("email"));
            pelanggan.setRole(rs.getString("role"));
            pelanggan.setNama(rs.getString("nama"));
            pelanggan.setNoTelp(rs.getString("no_telp"));
            pelanggan.setBirthdate(rs.getString("birthdate"));
            return pelanggan;
        }, userId);
    }

    // Melihat semua data pelanggan
    public List<Pelanggan> findAll() {
        String sql = "SELECT * FROM Pengguna";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Pelanggan pelanggan = new Pelanggan();
            pelanggan.setUserId(rs.getInt("user_id"));
            pelanggan.setUsername(rs.getString("username"));
            pelanggan.setPassword(rs.getString("password"));
            pelanggan.setEmail(rs.getString("email"));
            pelanggan.setRole(rs.getString("role"));
            pelanggan.setNama(rs.getString("nama"));
            pelanggan.setNoTelp(rs.getString("no_telp"));
            pelanggan.setBirthdate(rs.getString("birthdate"));
            return pelanggan;
        });
    }

    // Menghapus data pelanggan berdasarkan ID
    public void deleteById(int userId) {
        String sql = "DELETE FROM Pengguna WHERE user_id = ?";
        jdbcTemplate.update(sql, userId);
    }
}
