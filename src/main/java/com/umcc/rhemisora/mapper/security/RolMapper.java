package com.umcc.rhemisora.mapper.security;

import com.umcc.rhemisora.entity.MilitanciaEntity;
import com.umcc.rhemisora.entity.security.RolEntity;
import com.umcc.rhemisora.model.MilitanciaModel;
import com.umcc.rhemisora.model.security.RolModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RolMapper implements RowMapper<RolEntity> {

    @Override
    public RolEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        RolEntity rolEntity = new RolEntity();
        rolEntity.setId_rol(rs.getString("id_rol"));
        rolEntity.setNombre_rol(rs.getString("nombre_rol"));
        return rolEntity;
    }

    public static RolModel mapToModel(RolEntity entity) {
        if (entity == null) {
            return null;
        }
        RolModel model = new RolModel();
        model.setId_rol(entity.getId_rol());
        model.setNombre_rol(entity.getNombre_rol());
        return model;
    }

    public static RolEntity mapToEntity(RolModel model) {
        if (model == null) {
            return null;
        }
        RolEntity entity = new RolEntity();
        entity.setId_rol(model.getId_rol());
        entity.setNombre_rol(model.getNombre_rol());
        return entity;
    }

}
