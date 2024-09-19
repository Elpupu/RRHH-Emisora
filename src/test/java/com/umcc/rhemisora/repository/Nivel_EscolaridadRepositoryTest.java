package com.umcc.rhemisora.repository;

import com.umcc.rhemisora.entity.Nivel_EscolaridadEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class Nivel_EscolaridadRepositoryTest {

    @Autowired
    private Nivel_EscolaridadRepository nivelEscolaridadRepository;

    @Test
    public void insertNivel_Escolaridad() {
        Nivel_EscolaridadEntity entity = new Nivel_EscolaridadEntity();
        entity.setId_ne("n2");
        entity.setNivel_esc("Nivel 2");
        boolean result = nivelEscolaridadRepository.save(entity);
        Assert.isTrue(result, "INSERT NIVEL_ESCOLARIDAD TEST");
    }

    @Test
    void updateNivel_Escolaridad() {
        Nivel_EscolaridadEntity entity = new Nivel_EscolaridadEntity();
        entity.setNivel_esc("Nivel_EscolaridadModel Updated 1");
        entity.setId_ne("n1");
        boolean result = nivelEscolaridadRepository.update(entity);
        Assert.isTrue(result, "UPDATE NIVEL_ESCOLARIDAD TEST");
    }

    @Test
    void findAllNivel_Escolaridad() {
        List<Nivel_EscolaridadEntity> entities = nivelEscolaridadRepository.findAll();
        Assert.notNull(entities, "FIND ALL NIVEL_ESCOLARIDAD TEST");
    }

    @Test
    void findByIdNivel_Escolaridad() {
        Nivel_EscolaridadEntity entity = nivelEscolaridadRepository.findById("n1");
        Assert.notNull(entity, "FIND BY ID NIVEL_ESCOLARIDAD TEST");
    }

    @Test
    void deleteNivel_Escolaridad() {
        Nivel_EscolaridadEntity entity = nivelEscolaridadRepository.findById("n1");
        boolean result = nivelEscolaridadRepository.delete(entity);
        Assert.isTrue(result, "DELETE NIVEL_ESCOLARIDAD TEST");
    }
}
