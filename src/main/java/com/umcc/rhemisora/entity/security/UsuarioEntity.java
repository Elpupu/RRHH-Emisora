package com.umcc.rhemisora.entity.security;

public class UsuarioEntity {
    private String id_usuario;
    private String correo;
    private String clave;
    private RolEntity rol;

    public UsuarioEntity() {
    }

    public UsuarioEntity(String id_usuario, String correo, String clave, RolEntity rol) {
        this.id_usuario = id_usuario;
        this.correo = correo;
        this.clave = clave;
        this.rol = rol;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }
}
