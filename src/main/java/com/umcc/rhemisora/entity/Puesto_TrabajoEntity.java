package com.umcc.rhemisora.entity;

public class Puesto_TrabajoEntity {
    private String id_puest;
    private String nombre_puest;

    public Puesto_TrabajoEntity() {
    }

    public Puesto_TrabajoEntity(String id_puest, String nombre_puest) {
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
