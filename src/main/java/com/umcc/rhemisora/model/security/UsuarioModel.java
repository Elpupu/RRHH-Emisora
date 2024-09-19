package com.umcc.rhemisora.model.security;


public class UsuarioModel {
    private String id_usuario;
    private String correo;
    private String clave;
    private RolModel rol;

    public UsuarioModel() {
    }

    public UsuarioModel(String id_usuario, String correo, String clave, RolModel rol) {
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

    public RolModel getRol() {
        return rol;
    }

    public void setRol(RolModel rol) {
        this.rol = rol;
    }
}
