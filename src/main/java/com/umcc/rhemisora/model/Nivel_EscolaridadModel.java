package com.umcc.rhemisora.model;

public class Nivel_EscolaridadModel {
    private String id_ne;
    private String nivel_esc;

    public Nivel_EscolaridadModel() {
    }

    public Nivel_EscolaridadModel(String id_ne, String nivel_esc) {
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
