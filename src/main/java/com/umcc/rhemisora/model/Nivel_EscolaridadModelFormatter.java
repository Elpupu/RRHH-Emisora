package com.umcc.rhemisora.model;


import com.umcc.rhemisora.service.MunicipioService;
import com.umcc.rhemisora.service.Nivel_EscolaridadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class Nivel_EscolaridadModelFormatter implements Formatter<Nivel_EscolaridadModel> {

    @Autowired
    private Nivel_EscolaridadService nivel_escolaridadService;

    @Override
    public Nivel_EscolaridadModel parse(String text, Locale locale) throws ParseException {
        String id = String.valueOf(text);
        return this.nivel_escolaridadService.get(id);
    }

    @Override
    public String print(Nivel_EscolaridadModel object, Locale locale) {
        return (object != null ? object.getId_ne().toString() : "") ;
    }
}
