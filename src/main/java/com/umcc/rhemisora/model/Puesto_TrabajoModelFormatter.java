package com.umcc.rhemisora.model;

import com.umcc.rhemisora.service.Puesto_TrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class Puesto_TrabajoModelFormatter implements Formatter<Puesto_TrabajoModel> {

    @Autowired
    private Puesto_TrabajoService puestoTrabajoService;

    @Override
    public Puesto_TrabajoModel parse(String text, Locale locale) throws ParseException {
        String id = String.valueOf(text);
        return this.puestoTrabajoService.get(id);
    }

    @Override
    public String print(Puesto_TrabajoModel object, Locale locale) {
        return (object != null ? object.getId_puest().toString() : "");
    }
}
