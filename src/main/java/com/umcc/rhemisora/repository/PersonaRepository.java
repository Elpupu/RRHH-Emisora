package com.umcc.rhemisora.repository;

import com.umcc.rhemisora.entity.PersonaEntity;
import com.umcc.rhemisora.mapper.PersonaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PersonaRepository implements IPersonaRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(PersonaEntity element) {
        try {
            String sqlQuery = String.format("INSERT INTO persona (ci, nombre_persona, apellido1, apellido2, salario, id_mun, id_milit, id_piel, id_ne, id_puest)VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",element.getCi() ,element.getNombre_persona(), element.getApellido1(), element.getApellido2(), element.getSalario(), element.getMunicipio().getId_mun(), element.getMilitancia().getId_milit(), element.getPiel().getId_piel(), element.getNivel_escolaridad().getId_ne(), element.getPuesto_trabajo().getId_puest());
            jdbcTemplate.execute(sqlQuery);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(PersonaEntity element) {
        try {
            String sqlQuery = String.format("UPDATE persona SET nombre_persona='%s', apellido1='%s', apellido2='%s', salario='%s', id_mun='%s', id_milit='%s', id_piel='%s', id_ne='%s', id_puest='%s'  WHERE ci='%s'", element.getNombre_persona(), element.getApellido1(), element.getApellido2(), element.getSalario(), element.getMunicipio().getId_mun(), element.getMilitancia().getId_milit(), element.getPiel().getId_piel(), element.getNivel_escolaridad().getId_ne(), element.getPuesto_trabajo().getId_puest(), element.getCi());
            jdbcTemplate.execute(sqlQuery);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<PersonaEntity> findAll() {

        try {
            String sqlQuery = "SELECT persona.ci, persona.nombre_persona, persona.apellido1, persona.apellido2, persona.salario, persona.id_mun, persona.id_milit, persona.id_piel, persona.id_ne, persona.id_puest, municipio.id_mun mun_id, municipio.nombre_mun mun_nombre, militancia.id_milit mil_id, militancia.nombre_milit mil_nombre, piel.id_piel piel_id, piel.tipo_piel piel_nombre, nivel_escolaridad.id_ne niv_id, nivel_escolaridad.nivel_esc niv_nombre, puesto_trabajo.id_puest pue_id, puesto_trabajo.nombre_puest pue_nombre FROM persona, piel, militancia, nivel_escolaridad, municipio, puesto_trabajo WHERE persona.id_mun=municipio.id_mun AND persona.id_milit=militancia.id_milit AND persona.id_piel=piel.id_piel AND persona.id_ne=nivel_escolaridad.id_ne AND persona.id_puest=puesto_trabajo.id_puest";
            return jdbcTemplate.query(sqlQuery, new PersonaMapper());
        } catch (Exception e){

            return List.of();
        }
    }

    @Override
    public PersonaEntity findById(String id) {
        try {
            String sqlQuery =String.format("SELECT persona.ci, persona.nombre_persona, persona.apellido1, persona.apellido2, persona.salario, persona.id_mun, persona.id_milit, persona.id_piel,  persona.id_ne, persona.id_puest, municipio.id_mun mun_id, municipio.nombre_mun mun_nombre, militancia.id_milit mil_id, militancia.nombre_milit mil_nombre, piel.id_piel piel_id, piel.tipo_piel piel_nombre, nivel_escolaridad.id_ne niv_id, nivel_escolaridad.nivel_esc niv_nombre, puesto_trabajo.id_puest pue_id, puesto_trabajo.nombre_puest pue_nombre FROM persona, piel, militancia, nivel_escolaridad, municipio, puesto_trabajo WHERE persona.id_mun=municipio.id_mun AND persona.id_milit=militancia.id_milit AND persona.id_piel=piel.id_piel AND persona.id_ne=nivel_escolaridad.id_ne AND persona.id_puest=puesto_trabajo.id_puest AND ci='%s'", id);
            return jdbcTemplate.queryForObject(sqlQuery, new PersonaMapper());
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean delete(PersonaEntity element) {
        try {
            String sqlQuery =String.format("DELETE FROM persona WHERE ci='%s'", element.getCi());
            jdbcTemplate.execute(sqlQuery);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
