package com.umcc.rhemisora.repository;

import com.umcc.rhemisora.entity.MilitanciaEntity;
import com.umcc.rhemisora.mapper.MilitanciaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MilitanciaRepository implements IMilitanciaRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public boolean save(MilitanciaEntity element) {
        try {
            String sqlQuery = String.format("INSERT INTO militancia (id_milit, nombre_milit) VALUES ('%s', '%s')", element.getId_milit(), element.getNombre_milit());
            jdbcTemplate.execute(sqlQuery);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(MilitanciaEntity element) {
        try {
            String sqlQuery = String.format("UPDATE militancia SET nombre_milit='%s' WHERE id_milit='%s'", element.getNombre_milit(), element.getId_milit());
            jdbcTemplate.execute(sqlQuery);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<MilitanciaEntity> findAll() {
        try {
            String sqlQuery = "SELECT * FROM militancia";
            return jdbcTemplate.query(sqlQuery, new MilitanciaMapper());
        } catch (Exception e){
            return List.of();
        }
    }

    @Override
    public MilitanciaEntity findById(String id) {
        try {
            String sqlQuery =String.format("SELECT * FROM militancia WHERE id_milit='%s'", id);
            return jdbcTemplate.queryForObject(sqlQuery, new MilitanciaMapper());
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean delete(MilitanciaEntity element) {
        try {
            String sqlQuery =String.format("DELETE FROM militancia WHERE id_milit='%s'", element.getId_milit());
            jdbcTemplate.execute(sqlQuery);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
