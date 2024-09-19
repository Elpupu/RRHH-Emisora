package com.umcc.rhemisora.mapper;

import com.umcc.rhemisora.entity.MilitanciaEntity;
import com.umcc.rhemisora.model.MilitanciaModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MilitanciaMapper implements RowMapper<MilitanciaEntity> {

    @Override
    public MilitanciaEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        MilitanciaEntity militancia = new MilitanciaEntity();
        militancia.setId_milit(rs.getString("id_milit"));
        militancia.setNombre_milit(rs.getString("nombre_milit"));
        return militancia;
    }
    public static MilitanciaModel mapToModel(MilitanciaEntity entity) {
        if (entity == null) {
            return null;
        }
        MilitanciaModel model = new MilitanciaModel();
        model.setId_milit(entity.getId_milit());
        model.setNombre_milit(entity.getNombre_milit());
        return model;
    }

    public static MilitanciaEntity mapToEntity(MilitanciaModel model) {
        if (model == null) {
            return null;
        }
        MilitanciaEntity entity = new MilitanciaEntity();
        entity.setId_milit(model.getId_milit());
        entity.setNombre_milit(model.getNombre_milit());
        return entity;
    }
}
