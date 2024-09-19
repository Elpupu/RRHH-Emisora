package com.umcc.rhemisora.model;


import com.umcc.rhemisora.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class MunicipioModelFormatter implements Formatter<MunicipioModel> {

    @Autowired
    private MunicipioService municipioService;

    @Override
    public MunicipioModel parse(String text, Locale locale) throws ParseException {
        String id = text;
        return this.municipioService.get(id);
    }

    @Override
    public String print(MunicipioModel object, Locale locale) {
        return (object != null ? object.getId_mun() : "") ;
    }
}
