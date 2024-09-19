package com.umcc.rhemisora.model;

public class Puesto_TrabajoModel {
    private String id_puest;
    private String nombre_puest;

    public Puesto_TrabajoModel() {
    }

    public Puesto_TrabajoModel(String id_puest, String nombre_puest) {
        this.id_puest = id_puest;
        this.nombre_puest = nombre_puest;
    }

    public String getId_puest() {
        return id_puest;
    }

    public void setId_puest(String id_puest) {
        this.id_puest = id_puest;
    }

    public String getNombre_puest() {
        return nombre_puest;
    }

    public void setNombre_puest(String nombre_puest) {
        this.nombre_puest = nombre_puest;
    }
}
