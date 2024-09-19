package com.umcc.rhemisora.model.security;

import com.umcc.rhemisora.service.security.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class RolModelFormatter implements Formatter<RolModel> {

    @Autowired
    private RolService rolService;

    @Override
    public RolModel parse(String text, Locale locale) throws ParseException {
        String id = String.valueOf(text);
        return this.rolService.get(id);
    }

    @Override
    public String print(RolModel object, Locale locale) {
        return (object != null ? object.getId_rol().toString() : "") ;
    }
}
