package com.umcc.rhemisora.entity;

public class PersonaEntity {
    private String ci;
    private String nombre_persona;
    private String apellido1;
    private String apellido2;
    private double salario;
    private MunicipioEntity municipio;
    private MilitanciaEntity militancia;
    private PielEntity piel;
    private Nivel_EscolaridadEntity nivel_escolaridad;
    private Puesto_TrabajoEntity puesto_trabajo;

    public PersonaEntity() {
    }

    public PersonaEntity(String ci, String nombre_persona, String apellido1, String apellido2, double salario, MunicipioEntity municipio, MilitanciaEntity militancia, PielEntity piel, Nivel_EscolaridadEntity nivel_escolaridad, Puesto_TrabajoEntity puesto_trabajo) {
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

    public MunicipioEntity getMunicipio() {
        return municipio;
    }

    public void setMunicipio(MunicipioEntity municipio) {
        this.municipio = municipio;
    }

    public MilitanciaEntity getMilitancia() {
        return militancia;
    }

    public void setMilitancia(MilitanciaEntity militancia) {
        this.militancia = militancia;
    }

    public PielEntity getPiel() {
        return piel;
    }

    public void setPiel(PielEntity piel) {
        this.piel = piel;
    }

    public Nivel_EscolaridadEntity getNivel_escolaridad() {
        return nivel_escolaridad;
    }

    public void setNivel_escolaridad(Nivel_EscolaridadEntity nivel_escolaridad) {
        this.nivel_escolaridad = nivel_escolaridad;
    }

    public Puesto_TrabajoEntity getPuesto_trabajo() {
        return puesto_trabajo;
    }

    public void setPuesto_trabajo(Puesto_TrabajoEntity puesto_trabajo) {
        this.puesto_trabajo = puesto_trabajo;
    }
}

