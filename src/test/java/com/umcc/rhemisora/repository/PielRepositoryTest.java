package com.umcc.rhemisora.repository;

import com.umcc.rhemisora.entity.PielEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class PielRepositoryTest {

    @Autowired
    private PielRepository pielRepository;

    @Test
    public void insertPiel() {
        PielEntity entity = new PielEntity();
        entity.setId_piel("p1");
        entity.setTipo_piel("Piel1");
        boolean result = pielRepository.save(entity);
        Assert.isTrue(result, "INSERT PIEL TEST");
    }

    @Test
    void updatePiel() {
        PielEntity entity = new PielEntity();
        entity.setTipo_piel("Piel Updated 1");
        entity.setId_piel("p1");
        boolean result = pielRepository.update(entity);
        Assert.isTrue(result, "UPDATE PIEL TEST");
    }

    @Test
    void findAllPiel() {
        List<PielEntity> entities = pielRepository.findAll();
        Assert.notNull(entities, "FIND ALL PIEL TEST");
    }

    @Test
    void findByIdPiel() {
        PielEntity entity = pielRepository.findById("p1");
        Assert.notNull(entity, "FIND BY ID PIEL TEST");
    }

    @Test
    void deletePiel() {
        PielEntity entity = pielRepository.findById("p1");
        boolean result = pielRepository.delete(entity);
        Assert.isTrue(result, "DELETE PIEL TEST");
    }
}
