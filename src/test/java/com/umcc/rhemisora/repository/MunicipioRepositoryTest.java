package com.umcc.rhemisora.repository;

import com.umcc.rhemisora.entity.MunicipioEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class MunicipioRepositoryTest {

    @Autowired
    private MunicipioRepository municipioRepository;

    @Test
    public void insertMunicipio() {
        MunicipioEntity entity = new MunicipioEntity();
        entity.setId_mun("m1");
        entity.setNombre_mun("Municipio1");
        boolean result = municipioRepository.save(entity);
        Assert.isTrue(result, "INSERT MUNICIPIO TEST");
    }

    @Test
    void updateMunicipio() {
        MunicipioEntity entity = new MunicipioEntity();
        entity.setNombre_mun("Municipio Updated 1");
        entity.setId_mun("m2");
        boolean result = municipioRepository.update(entity);
        Assert.isTrue(result, "UPDATE MUNICIPIO TEST");
    }

    @Test
    void findAllMunicipio() {
        List<MunicipioEntity> entities = municipioRepository.findAll();
        Assert.notNull(entities, "FIND ALL MUNICIPIO TEST");
    }

    @Test
    void findByIdMunicipio() {
        MunicipioEntity entity = municipioRepository.findById("m1");
        Assert.notNull(entity, "FIND BY ID MUNICIPIO TEST");
    }

    @Test
    void deleteMunicipio() {
        MunicipioEntity entity = municipioRepository.findById("m1");
        boolean result = municipioRepository.delete(entity);
        Assert.isTrue(result, "DELETE MUNICIPIO TEST");
    }
}
