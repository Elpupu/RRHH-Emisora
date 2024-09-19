package com.umcc.rhemisora.model;

public class MilitanciaModel {
    private String id_milit;
    private String nombre_milit;

    public MilitanciaModel() {
    }

    public MilitanciaModel(String id_milit, String nombre_milit) {
        this.id_milit = id_milit;
        this.nombre_milit = nombre_milit;
    }

    public String getId_milit() {
        return id_milit;
    }

    public void setId_milit(String id_milit) {
        this.id_milit = id_milit;
    }

    public String getNombre_milit() {
        return nombre_milit;
    }

    public void setNombre_milit(String nombre_milit) {
        this.nombre_milit = nombre_milit;
    }
}
