package com.umcc.rhemisora.repository;

import com.umcc.rhemisora.entity.PielEntity;
import com.umcc.rhemisora.mapper.PielMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PielRepository implements IPielRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(PielEntity element) {
        try {
            String sqlQuery = String.format("INSERT INTO piel (id_piel, tipo_piel) VALUES ('%s', '%s')", element.getId_piel(), element.getTipo_piel());
            jdbcTemplate.execute(sqlQuery);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(PielEntity element) {
        try {
            String sqlQuery = String.format("UPDATE piel SET tipo_piel='%s' WHERE id_piel='%s'", element.getTipo_piel(), element.getId_piel());
            jdbcTemplate.execute(sqlQuery);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<PielEntity> findAll() {
        try {
            String sqlQuery = "SELECT * FROM piel";
            return jdbcTemplate.query(sqlQuery, new PielMapper());
        } catch (Exception e) {
            return List.of();
        }
    }

    @Override
    public PielEntity findById(String id) {
        try {
            String sqlQuery = String.format("SELECT * FROM piel WHERE id_piel='%s'", id);
            return jdbcTemplate.queryForObject(sqlQuery, new PielMapper());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean delete(PielEntity element) {
        try {
            String sqlQuery = String.format("DELETE FROM piel WHERE id_piel='%s'", element.getId_piel());
            jdbcTemplate.execute(sqlQuery);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
