package com.umcc.rhemisora.mapper;

import com.umcc.rhemisora.entity.Nivel_EscolaridadEntity;
import com.umcc.rhemisora.model.Nivel_EscolaridadModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Nivel_EscolaridadMapper implements RowMapper<Nivel_EscolaridadEntity> {
    @Override
    public Nivel_EscolaridadEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        Nivel_EscolaridadEntity nivel_escolaridad = new Nivel_EscolaridadEntity();
                nivel_escolaridad.setId_ne(rs.getString("id_ne"));
                nivel_escolaridad.setNivel_esc(rs.getString("nivel_esc"));
                return nivel_escolaridad;
    }
    public static Nivel_EscolaridadModel mapToModel(Nivel_EscolaridadEntity entity) {
        if (entity == null) {
            return null;
        }
        Nivel_EscolaridadModel model = new Nivel_EscolaridadModel();
        model.setId_ne(entity.getId_ne());
        model.setNivel_esc(entity.getNivel_esc());
        return model;
    }

    public static Nivel_EscolaridadEntity mapToEntity(Nivel_EscolaridadModel model) {
        if (model == null) {
            return null;
        }
        Nivel_EscolaridadEntity entity = new Nivel_EscolaridadEntity();
        entity.setId_ne(model.getId_ne());
        entity.setNivel_esc(model.getNivel_esc());
        return entity;
    }
}
