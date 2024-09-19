package com.umcc.rhemisora.mapper;

import com.umcc.rhemisora.entity.PielEntity;
import com.umcc.rhemisora.model.PielModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PielMapper implements RowMapper<PielEntity> {

    @Override
    public PielEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        PielEntity piel = new PielEntity();
        piel.setId_piel(rs.getString("id_piel"));
        piel.setTipo_piel(rs.getString("tipo_piel"));
        return piel;
    }

    public static PielModel mapToModel(PielEntity entity) {
        if (entity == null) {
            return null;
        }
        PielModel model = new PielModel();
        model.setId_piel(entity.getId_piel());
        model.setTipo_piel(entity.getTipo_piel());
        return model;
    }

    public static PielEntity mapToEntity(PielModel model) {
        if (model == null) {
            return null;
        }
        PielEntity entity = new PielEntity();
        entity.setId_piel(model.getId_piel());
        entity.setTipo_piel(model.getTipo_piel());
        return entity;
    }
}
