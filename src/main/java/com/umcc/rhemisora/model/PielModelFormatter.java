package com.umcc.rhemisora.model;


import com.umcc.rhemisora.service.MunicipioService;
import com.umcc.rhemisora.service.PielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PielModelFormatter implements Formatter<PielModel> {

    @Autowired
    private PielService pielService;

    @Override
    public PielModel parse(String text, Locale locale) throws ParseException {
        String id = String.valueOf(text);
        return this.pielService.get(id);
    }

    @Override
    public String print(PielModel object, Locale locale) {
        return (object != null ? object.getId_piel().toString() : "") ;
    }
}
