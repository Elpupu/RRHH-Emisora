package com.umcc.rhemisora.repository;

import com.umcc.rhemisora.entity.Puesto_TrabajoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class Puesto_TrabajoRepositoryTest {

    @Autowired
    private Puesto_TrabajoRepository puestoTrabajoRepository;

    @Test
    public void insertPuesto_Trabajo() {
        Puesto_TrabajoEntity entity = new Puesto_TrabajoEntity();
        entity.setId_puest("pt1");
        entity.setNombre_puest("PuesTrab1");
        boolean result = puestoTrabajoRepository.save(entity);
        Assert.isTrue(result, "INSERT PUESTO_TRABAJO TEST");
    }

    @Test
    void updatePuesto_Trabajo() {
        Puesto_TrabajoEntity entity = new Puesto_TrabajoEntity();
        entity.setId_puest("pt1");
        entity.setNombre_puest("PuesTrab1 Update");
        boolean result = puestoTrabajoRepository.update(entity);
        Assert.isTrue(result, "UPDATE PUESTO_TRABAJO TEST");
    }

    @Test
    void findAllPuesto_Trabajo() {
        List<Puesto_TrabajoEntity> entities = puestoTrabajoRepository.findAll();
        Assert.notNull(entities, "FIND ALL PUESTO_TRABAJO TEST");
    }

    @Test
    void findByIdPuesto_Trabajo() {
        Puesto_TrabajoEntity entity = puestoTrabajoRepository.findById("pt1");
        Assert.notNull(entity, "FIND BY ID PUESTO_TRABAJO TEST");
    }

    @Test
    void deletePuesto_Trabajo() {
        Puesto_TrabajoEntity entity = puestoTrabajoRepository.findById("pt1");
        boolean result = puestoTrabajoRepository.delete(entity);
        Assert.isTrue(result, "DELETE PUESTO_TRABAJO TEST");
    }
}
