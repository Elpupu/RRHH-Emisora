package com.umcc.rhemisora.model;


import com.umcc.rhemisora.service.MilitanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class MilitanciaModelFormatter implements Formatter<MilitanciaModel> {

    @Autowired
    private MilitanciaService militanciaService;

    @Override
    public MilitanciaModel parse(String text, Locale locale) throws ParseException {
        String id = String.valueOf(text);
        return this.militanciaService.get(id);
    }

    @Override
    public String print(MilitanciaModel object, Locale locale) {
        return (object != null ? object.getId_milit().toString() : "") ;
    }
}
