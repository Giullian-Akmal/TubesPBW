//repositori ini untuk menangani database terkait pelanggan

package com.example.tubesPBW.Repo;

import com.example.tubesPBW.Data.Member;
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
    public void save(Member pelanggan) {
        String sql = "INSERT INTO Pengguna (id, username, password, email) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, pelanggan.getId(), pelanggan.getUsername(), pelanggan.getPassword(), pelanggan.getEmail());
    }

    // Mengambil data pelanggan berdasarkan id
    public Member findById(int userId) {
        String sql = "SELECT * FROM Pengguna WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Member pelanggan = new Member(userId, sql, sql, sql);
            pelanggan.setId(rs.getInt("user_id"));
            pelanggan.setUsername(rs.getString("username"));
            pelanggan.setPassword(rs.getString("password"));
            pelanggan.setEmail(rs.getString("email"));
            return pelanggan;
        }, userId);
    }

    // Melihat semua data pelanggan
    public List<Member> findAll() {
        String sql = "SELECT * FROM Pengguna";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Member pelanggan = new Member(rowNum, sql, sql, sql);
            pelanggan.setId(rs.getInt("user_id"));
            pelanggan.setUsername(rs.getString("username"));
            pelanggan.setPassword(rs.getString("password"));
            pelanggan.setEmail(rs.getString("email"));
            return pelanggan;
        });
    }

    // Menghapus data pelanggan berdasarkan ID
    public void deleteById(int userId) {
        String sql = "DELETE FROM Pengguna WHERE user_id = ?";
        jdbcTemplate.update(sql, userId);
    }
}
