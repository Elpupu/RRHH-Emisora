package com.umcc.rhemisora.repository;

import com.umcc.rhemisora.entity.MunicipioEntity;
import com.umcc.rhemisora.mapper.MunicipioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceUnwrapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MunicipioRepository implements IMunicipioRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public boolean save(MunicipioEntity element) {
        try {
            String sqlQuery = String.format("INSERT INTO municipio (id_mun, nombre_mun) VALUES ('%s', '%s')", element.getId_mun() ,element.getNombre_mun());
            jdbcTemplate.execute(sqlQuery);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(MunicipioEntity element) {
        try {
            String sqlQuery = String.format("UPDATE municipio SET nombre_mun='%s' WHERE id_mun='%s'", element.getNombre_mun(), element.getId_mun());
            jdbcTemplate.execute(sqlQuery);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<MunicipioEntity> findAll() {
        try {
            String sqlQuery = "SELECT * FROM municipio";
            return jdbcTemplate.query(sqlQuery, new MunicipioMapper());
        } catch (Exception e){
            return List.of();
        }
    }

    @Override
    public MunicipioEntity findById(String id) {
        try {
            String sqlQuery =String.format("SELECT * FROM municipio WHERE id_mun='%s'", id);
            return jdbcTemplate.queryForObject(sqlQuery, new MunicipioMapper());
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean delete(MunicipioEntity element) {
        try {
            String sqlQuery =String.format("DELETE FROM municipio WHERE id_mun='%s'", element.getId_mun());
            jdbcTemplate.execute(sqlQuery);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
