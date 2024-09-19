package com.umcc.rhemisora.repository.security;

import com.umcc.rhemisora.entity.security.RolEntity;
import com.umcc.rhemisora.mapper.MilitanciaMapper;
import com.umcc.rhemisora.mapper.security.RolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RolRepository implements IRolRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public boolean save(RolEntity element) {
        try {
            String sqlQuery = String.format("INSERT INTO rol (id_rol, nombre_rol) VALUES ('%s', '%s')", element.getId_rol(), element.getNombre_rol());
            jdbcTemplate.execute(sqlQuery);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(RolEntity element) {
        try {
            String sqlQuery = String.format("UPDATE rol SET nombre_rol='%s' WHERE id_rol='%s'", element.getNombre_rol(), element.getId_rol());
            jdbcTemplate.execute(sqlQuery);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<RolEntity> findAll() {
        try {
            String sqlQuery = "SELECT * FROM rol";
            return jdbcTemplate.query(sqlQuery, new RolMapper());
        } catch (Exception e){
            return List.of();
        }
    }

    @Override
    public RolEntity findById(String id) {
        try {
            String sqlQuery =String.format("SELECT * FROM rol WHERE id_rol='%s'", id);
            return jdbcTemplate.queryForObject(sqlQuery, new RolMapper());
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean delete(RolEntity element) {
        try {
            String sqlQuery =String.format("DELETE FROM rol WHERE id_rol='%s'", element.getId_rol());
            jdbcTemplate.execute(sqlQuery);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
