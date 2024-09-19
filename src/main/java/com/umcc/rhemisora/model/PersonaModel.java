package com.umcc.rhemisora.model;

import com.umcc.rhemisora.entity.*;
import com.umcc.rhemisora.mapper.MilitanciaMapper;

public class PersonaModel {
    private String ci;
    private String nombre_persona;
    private String apellido1;
    private String apellido2;
    private double salario;
    private MunicipioModel municipio;
    private MilitanciaModel militancia;
    private PielModel piel;
    private Nivel_EscolaridadModel nivel_escolaridad;
    private Puesto_TrabajoModel puesto_trabajo;

    public PersonaModel() {
    }

    public PersonaModel(String ci, String nombre_persona, String apellido1, String apellido2, double salario, MunicipioModel municipio, MilitanciaModel militancia, PielModel piel, Nivel_EscolaridadModel nivel_escolaridad, Puesto_TrabajoModel puesto_trabajo) {
        this.ci = ci;
        this.nombre_persona = nombre_persona;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.salario = salario;
        this.municipio = municipio;
        this.militancia = militancia;
        this.piel = piel;
        this.nivel_escolaridad = nivel_escolaridad;
        this.puesto_trabajo = puesto_trabajo;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public MunicipioModel getMunicipio() {
        return municipio;
    }

    public void setMunicipio(MunicipioModel municipio) {
        this.municipio = municipio;
    }

    public MilitanciaModel getMilitancia() {
        return militancia;
    }

    public void setMilitancia(MilitanciaModel militancia) {
        this.militancia = militancia;
    }

    public PielModel getPiel() {
        return piel;
    }

    public void setPiel(PielModel piel) {
        this.piel = piel;
    }

    public Nivel_EscolaridadModel getNivel_escolaridad() {
        return nivel_escolaridad;
    }

    public void setNivel_escolaridad(Nivel_EscolaridadModel nivel_escolaridad) {
        this.nivel_escolaridad = nivel_escolaridad;
    }

    public Puesto_TrabajoModel getPuesto_trabajo() {
        return puesto_trabajo;
    }

    public void setPuesto_trabajo(Puesto_TrabajoModel puesto_trabajo) {
        this.puesto_trabajo = puesto_trabajo;
    }
}
