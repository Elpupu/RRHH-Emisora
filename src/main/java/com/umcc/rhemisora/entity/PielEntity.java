package com.umcc.rhemisora.entity;

public class PielEntity {
    private String id_piel;
    private String tipo_piel;

    public PielEntity() {
    }

    public PielEntity(String id_piel, String tipo_piel) {
        this.id_piel = id_piel;
        this.tipo_piel = tipo_piel;
    }

    public String getId_piel() {
        return id_piel;
    }

    public void setId_piel(String id_piel) {
        this.id_piel = id_piel;
    }

    public String getTipo_piel() {
        return tipo_piel;
    }

    public void setTipo_piel(String tipo_piel) {
        this.tipo_piel = tipo_piel;
    }
}
