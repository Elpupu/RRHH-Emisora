package com.umcc.rhemisora.repository;

import com.umcc.rhemisora.entity.Puesto_TrabajoEntity;
import com.umcc.rhemisora.mapper.Puesto_TrabajoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Puesto_TrabajoRepository implements IPuesto_TrabajoRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(Puesto_TrabajoEntity element) {
        try {
            String sqlQuery = String.format("INSERT INTO puesto_trabajo (id_puest, nombre_puest) VALUES ('%s', '%s')", element.getId_puest(), element.getNombre_puest());
            jdbcTemplate.execute(sqlQuery);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Puesto_TrabajoEntity element) {
        try {
            String sqlQuery = String.format("UPDATE puesto_trabajo SET nombre_puest='%s' WHERE id_puest='%s'", element.getNombre_puest(), element.getId_puest());
            jdbcTemplate.execute(sqlQuery);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Puesto_TrabajoEntity> findAll() {
        try {
            String sqlQuery = "SELECT * FROM puesto_trabajo";
            return jdbcTemplate.query(sqlQuery, new Puesto_TrabajoMapper());
        } catch (Exception e) {
            return List.of();
        }
    }

    @Override
    public Puesto_TrabajoEntity findById(String id) {
        try {
            String sqlQuery = String.format("SELECT * FROM puesto_trabajo WHERE id_puest='%s'", id);
            return jdbcTemplate.queryForObject(sqlQuery, new Puesto_TrabajoMapper());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean delete(Puesto_TrabajoEntity element) {
        try {
            String sqlQuery = String.format("DELETE FROM puesto_trabajo WHERE id_puest='%s'", element.getId_puest());
            jdbcTemplate.execute(sqlQuery);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
