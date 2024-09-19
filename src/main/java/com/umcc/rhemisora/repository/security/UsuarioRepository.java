package com.umcc.rhemisora.repository.security;

import com.umcc.rhemisora.entity.security.UsuarioEntity;
import com.umcc.rhemisora.mapper.MilitanciaMapper;
import com.umcc.rhemisora.mapper.security.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepository implements IUsuarioRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(UsuarioEntity element) {
        try {
            String sqlQuery = String.format("INSERT INTO usuario (id_usuario, correo, clave, id_rol) VALUES ('%s', '%s', '%s', '%s')", element.getId_usuario(), element.getCorreo(), element.getClave(), element.getRol().getId_rol());
            jdbcTemplate.execute(sqlQuery);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(UsuarioEntity element) {
        try {
            String sqlQuery = String.format("UPDATE usuario SET correo='%s', clave='%s', id_rol='%s' WHERE id_usuario='%s'", element.getCorreo(), element.getClave(), element.getRol().getId_rol(), element.getId_usuario());
            jdbcTemplate.execute(sqlQuery);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<UsuarioEntity> findAll() {
        try {
            String sqlQuery = "SELECT usuario.id_usuario, usuario.correo, usuario.clave, usuario.id_rol, rol.id_rol rol_id, rol.nombre_rol rol_nombre FROM usuario, rol WHERE usuario.id_rol=rol.id_rol";
            return jdbcTemplate.query(sqlQuery, new UsuarioMapper());
        } catch (Exception e){
            return List.of();
        }
    }

    @Override
    public UsuarioEntity findById(String id) {
        try {
            String sqlQuery =String.format("SELECT usuario.id_usuario, usuario.correo, usuario.clave, usuario.id_rol, rol.id_rol rol_id, rol.nombre_rol rol_nombre FROM usuario, rol WHERE usuario.id_rol=rol.id_rol AND usuario.id_usuario='%s'", id);
            return jdbcTemplate.queryForObject(sqlQuery, new UsuarioMapper());
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean delete(UsuarioEntity element) {
        try {
            String sqlQuery =String.format("DELETE FROM usuario WHERE id_usuario='%s'", element.getId_usuario());
            jdbcTemplate.execute(sqlQuery);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public UsuarioEntity findByEmail(String correo) {
        try{
            String sqlQuery =String.format("SELECT usuario.id_usuario, usuario.correo, usuario.clave, usuario.id_rol, rol.id_rol rol_id, rol.nombre_rol rol_nombre FROM usuario, rol WHERE usuario.id_rol=rol.id_rol AND usuario.correo='%s'", correo);
            return jdbcTemplate.queryForObject(sqlQuery, new UsuarioMapper());
        }catch (Exception e){
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
