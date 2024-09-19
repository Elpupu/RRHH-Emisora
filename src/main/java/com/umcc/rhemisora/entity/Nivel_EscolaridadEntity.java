package com.umcc.rhemisora.entity;

public class Nivel_EscolaridadEntity {
    private String id_ne;
    private String nivel_esc;

    public Nivel_EscolaridadEntity() {
    }

    public Nivel_EscolaridadEntity(String id_ne, String nivel_esc) {
        this.id_ne = id_ne;
        this.nivel_esc = nivel_esc;
    }

    public String getId_ne() {
        return id_ne;
    }

    public void setId_ne(String id_ne) {
        this.id_ne = id_ne;
    }

    public String getNivel_esc() {
        return nivel_esc;
    }

    public void setNivel_esc(String nivel_esc) {
        this.nivel_esc = nivel_esc;
    }
}
