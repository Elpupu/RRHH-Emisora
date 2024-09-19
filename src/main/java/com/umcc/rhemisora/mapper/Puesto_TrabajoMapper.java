package com.umcc.rhemisora.mapper;

import com.umcc.rhemisora.entity.Puesto_TrabajoEntity;
import com.umcc.rhemisora.model.Puesto_TrabajoModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Puesto_TrabajoMapper implements RowMapper<Puesto_TrabajoEntity> {

    @Override
    public Puesto_TrabajoEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        Puesto_TrabajoEntity puesto_trabajo = new Puesto_TrabajoEntity();
        puesto_trabajo.setId_puest(rs.getString("id_puest"));
        puesto_trabajo.setNombre_puest(rs.getString("nombre_puest"));
        return puesto_trabajo;
    }
    public static Puesto_TrabajoModel mapToModel(Puesto_TrabajoEntity entity) {
        if (entity == null) {
            return null;
        }
        Puesto_TrabajoModel model = new Puesto_TrabajoModel();
        model.setId_puest(entity.getId_puest());
        model.setNombre_puest(entity.getNombre_puest());
        return model;
    }

    public static Puesto_TrabajoEntity mapToEntity(Puesto_TrabajoModel model) {
        if (model == null) {
            return null;
        }
        Puesto_TrabajoEntity entity = new Puesto_TrabajoEntity();
        entity.setId_puest(model.getId_puest());
        entity.setNombre_puest(model.getNombre_puest());
        return entity;
    }
}
