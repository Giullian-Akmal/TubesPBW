//repositori ini untuk menangani database terkait pelanggan

package com.example.tubesPBW.Repo;

import com.example.tubesPBW.Data.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class PelangganRepository {

    private final JdbcTemplate jdbcTemplate;

    public PelangganRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isValidUser(String email, String password) {
        String sql = "SELECT COUNT(*) FROM pengguna WHERE email = ? AND password = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email, password);
        return count != null && count > 0;
    }

    // Menyimpan data pelanggan baru
    public void save(String name,String email,String password, String notelp) {
        String sql = "insert into pengguna (username,password,email,nomortelepon) values(?,?,?,?)";
        jdbcTemplate.update(sql, name,password,email,notelp);
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

    public void addpinjam(String judulfilm,String durasi) {
        String sql = "INSERT INTO Peminjaman (judulfilm, durasi) VALUES (?,?)";
        jdbcTemplate.update(sql, judulfilm,durasi);
    }

}
