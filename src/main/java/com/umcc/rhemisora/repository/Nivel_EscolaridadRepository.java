package com.umcc.rhemisora.repository;

import com.umcc.rhemisora.entity.Nivel_EscolaridadEntity;
import com.umcc.rhemisora.mapper.Nivel_EscolaridadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Nivel_EscolaridadRepository implements INivel_EscolaridadRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(Nivel_EscolaridadEntity element) {
        try {
            String sqlQuery = String.format("INSERT INTO nivel_escolaridad (id_ne, nivel_esc) VALUES ('%s', '%s')", element.getId_ne(), element.getNivel_esc());
            jdbcTemplate.execute(sqlQuery);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Nivel_EscolaridadEntity element) {
        try {
            String sqlQuery = String.format("UPDATE nivel_escolaridad SET nivel_esc='%s' WHERE id_ne='%s'", element.getNivel_esc(), element.getId_ne());
            jdbcTemplate.execute(sqlQuery);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Nivel_EscolaridadEntity> findAll() {
        try {
            String sqlQuery = "SELECT * FROM nivel_escolaridad";
            return jdbcTemplate.query(sqlQuery, new Nivel_EscolaridadMapper());
        } catch (Exception e) {
            return List.of();
        }
    }

    @Override
    public Nivel_EscolaridadEntity findById(String id) {
        try {
            String sqlQuery = String.format("SELECT * FROM nivel_escolaridad WHERE id_ne='%s'", id);
            return jdbcTemplate.queryForObject(sqlQuery, new Nivel_EscolaridadMapper());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean delete(Nivel_EscolaridadEntity element) {
        try {
            String sqlQuery = String.format("DELETE FROM nivel_escolaridad WHERE id_ne='%s'", element.getId_ne());
            jdbcTemplate.execute(sqlQuery);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
