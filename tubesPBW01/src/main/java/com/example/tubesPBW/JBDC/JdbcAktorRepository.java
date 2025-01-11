package com.example.tubesPBW.JBDC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.tubesPBW.Data.Aktor;
import com.example.tubesPBW.Repo.AktorRepository;

@Repository
public class JdbcAktorRepository implements AktorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Aktor> findAll() {
        String sql = "SELECT * FROM Actors";
        return jdbcTemplate.query(sql, this::mapRowToGenre);
    }

    private Aktor mapRowToGenre(ResultSet resultSet, int rowNum) throws SQLException {
        return new Aktor(
            resultSet.getInt("actor_id"),                  // Ambil ID
            resultSet.getString("nama_actor")        // Ambil Username
        );
    }


}