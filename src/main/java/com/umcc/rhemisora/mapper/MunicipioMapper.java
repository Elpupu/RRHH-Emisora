package com.umcc.rhemisora.mapper;

import com.umcc.rhemisora.entity.MunicipioEntity;
import com.umcc.rhemisora.model.MunicipioModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MunicipioMapper implements RowMapper<MunicipioEntity> {

    @Override
    public MunicipioEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        MunicipioEntity municipio = new MunicipioEntity();
        municipio.setId_mun(rs.getString("id_mun"));
        municipio.setNombre_mun(rs.getString("nombre_mun"));
        return municipio;
    }

    public static MunicipioModel mapToModel(MunicipioEntity entity) {
        if (entity == null) {
            return null;
        }
        MunicipioModel model = new MunicipioModel();
        model.setId_mun(entity.getId_mun());
        model.setNombre_mun(entity.getNombre_mun());
        return model;
    }

    public static MunicipioEntity mapToEntity(MunicipioModel model) {
        if (model == null) {
            return null;
        }
        MunicipioEntity entity = new MunicipioEntity();
        entity.setId_mun(model.getId_mun());
        entity.setNombre_mun(model.getNombre_mun());
        return entity;
    }
}
