package com.umcc.rhemisora.model;

public class MunicipioModel {
    private String id_mun;
    private String nombre_mun;

    public MunicipioModel() {
    }

    public MunicipioModel(String id_mun, String nombre_mun) {
        this.id_mun = id_mun;
        this.nombre_mun = nombre_mun;
    }

    public String getId_mun() {
        return id_mun;
    }

    public void setId_mun(String id_mun) {
        this.id_mun = id_mun;
    }

    public String getNombre_mun() {
        return nombre_mun;
    }

    public void setNombre_mun(String nombre_mun) {
        this.nombre_mun = nombre_mun;
    }
}
