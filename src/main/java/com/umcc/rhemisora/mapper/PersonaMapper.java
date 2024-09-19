package com.umcc.rhemisora.mapper;

import com.umcc.rhemisora.entity.*;
import com.umcc.rhemisora.model.*;
import com.umcc.rhemisora.model.PersonaModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaMapper implements RowMapper<PersonaEntity> {
    @Override
    public PersonaEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        PersonaEntity persona = new PersonaEntity();
        persona.setCi(rs.getString("ci"));
        persona.setNombre_persona(rs.getString("nombre_persona"));
        persona.setApellido1(rs.getString("apellido1"));
        persona.setApellido2(rs.getString("apellido2"));
        persona.setSalario(rs.getDouble("salario"));

        MunicipioEntity municipio = new MunicipioEntity(rs.getString("mun_id"), rs.getString("mun_nombre"));
        MilitanciaEntity militancia = new MilitanciaEntity(rs.getString("mil_id"), rs.getString("mil_nombre"));
        PielEntity piel = new PielEntity(rs.getString("piel_id"), rs.getString("piel_nombre"));
        Nivel_EscolaridadEntity nivel_escolaridad = new Nivel_EscolaridadEntity(rs.getString("niv_id"), rs.getString("niv_nombre") );
        Puesto_TrabajoEntity puesto_trabajo = new Puesto_TrabajoEntity(rs.getString("pue_id"), rs.getString("pue_nombre"));


        persona.setMunicipio(municipio);
        persona.setPiel(piel);
        persona.setNivel_escolaridad(nivel_escolaridad);
        persona.setMilitancia(militancia);
        persona.setPuesto_trabajo(puesto_trabajo);
        return persona;
    }
    public static PersonaModel mapToModel(PersonaEntity entity) {
        if (entity == null) {
            return null;
        }
        PersonaModel model = new PersonaModel();
        model.setCi(entity.getCi());
        model.setNombre_persona(entity.getNombre_persona());
        model.setApellido1(entity.getApellido1());
        model.setApellido2(entity.getApellido2());
        model.setSalario(entity.getSalario());

        model.setMunicipio(MunicipioMapper.mapToModel(entity.getMunicipio()));
        model.setMilitancia(MilitanciaMapper.mapToModel(entity.getMilitancia()));
        model.setPiel(PielMapper.mapToModel(entity.getPiel()));
        model.setNivel_escolaridad(Nivel_EscolaridadMapper.mapToModel(entity.getNivel_escolaridad()));
        model.setPuesto_trabajo(Puesto_TrabajoMapper.mapToModel(entity.getPuesto_trabajo()));
        return model;
    }

    public static PersonaEntity mapToEntity(PersonaModel model) {
        if (model == null) {
            return null;
        }
        PersonaEntity entity = new PersonaEntity();
        entity.setCi(model.getCi());
        entity.setNombre_persona(model.getNombre_persona());
        entity.setApellido1(model.getApellido1());
        entity.setApellido2(model.getApellido2());
        entity.setSalario(model.getSalario());

        entity.setMunicipio(MunicipioMapper.mapToEntity(model.getMunicipio()));
        entity.setMilitancia(MilitanciaMapper.mapToEntity(model.getMilitancia()));
        entity.setPiel(PielMapper.mapToEntity(model.getPiel()));
        entity.setNivel_escolaridad(Nivel_EscolaridadMapper.mapToEntity(model.getNivel_escolaridad()));
        entity.setPuesto_trabajo(Puesto_TrabajoMapper.mapToEntity(model.getPuesto_trabajo()));
        return entity;
    }
}
