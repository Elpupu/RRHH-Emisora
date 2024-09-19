package com.umcc.rhemisora.mapper.security;

import com.umcc.rhemisora.entity.security.RolEntity;
import com.umcc.rhemisora.entity.security.UsuarioEntity;
import com.umcc.rhemisora.model.security.UsuarioModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioMapper implements RowMapper<UsuarioEntity> {
    @Override
    public UsuarioEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId_usuario(rs.getString("id_usuario"));
        usuarioEntity.setClave(rs.getString("clave"));
        usuarioEntity.setCorreo(rs.getString("correo"));

        RolEntity rolEntity = new RolEntity(rs.getString("rol_id"), rs.getString("rol_nombre"));
        usuarioEntity.setRol(rolEntity);
        return usuarioEntity;
    }
    public static UsuarioModel mapToModel(UsuarioEntity entity) {
        if (entity == null) {
            return null;
        }
        UsuarioModel model = new UsuarioModel();
        model.setId_usuario(entity.getId_usuario());
        model.setClave(entity.getClave());
        model.setCorreo(entity.getCorreo());

        model.setRol(RolMapper.mapToModel(entity.getRol()));
        return model;
    }
    public static UsuarioEntity mapToEntity(UsuarioModel model) {
        if (model == null) {
            return null;
        }
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId_usuario(model.getId_usuario());
        entity.setClave(model.getClave());
        entity.setCorreo(model.getCorreo());

        entity.setRol(RolMapper.mapToEntity(model.getRol()));
        return entity;
    }
}
