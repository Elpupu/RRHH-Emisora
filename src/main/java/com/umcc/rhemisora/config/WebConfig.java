package com.umcc.rhemisora.config;

import com.umcc.rhemisora.model.*;
import com.umcc.rhemisora.model.security.RolModelFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(value = { "com.umcc.rhemisora"})
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private MunicipioModelFormatter municipioModelFormatter;
    @Autowired
    private MilitanciaModelFormatter militanciaModelFormatter;
    @Autowired
    private PielModelFormatter pielModelFormatter;
    @Autowired
    private Nivel_EscolaridadModelFormatter nivelEscolaridadModelFormatter;
    @Autowired
    private Puesto_TrabajoModelFormatter puestoTrabajoModelFormatter;
    @Autowired
    private RolModelFormatter rolModelFormatter;

    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addFormatter(municipioModelFormatter);
        registry.addFormatter(militanciaModelFormatter);
        registry.addFormatter(pielModelFormatter);
        registry.addFormatter(nivelEscolaridadModelFormatter);
        registry.addFormatter(puestoTrabajoModelFormatter);
        registry.addFormatter(rolModelFormatter);
    }
}
