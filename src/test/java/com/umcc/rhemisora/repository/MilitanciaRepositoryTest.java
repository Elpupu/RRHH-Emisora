package com.umcc.rhemisora.repository;

import com.umcc.rhemisora.entity.MilitanciaEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class MilitanciaRepositoryTest {
    @Autowired
    private MilitanciaRepository militanciaRepository;

    @Test
    public void insertMilitancia(){
        MilitanciaEntity entity = new MilitanciaEntity();
        entity.setId_milit("mi1");
        entity.setNombre_milit("Militancia1");
        boolean result = militanciaRepository.save(entity);
        Assert.isTrue(result, "INSERT MILITANCIA TEST");
    }

    @Test
    void updateMilitancia(){
        MilitanciaEntity entity = new MilitanciaEntity();
        entity.setNombre_milit("Militancia Updated 1");
        entity.setId_milit("mi1");
        boolean result = militanciaRepository.update(entity);
        Assert.isTrue(result, "UPDATE MILITANCIA TEST");
    }

    @Test
    void findAllMilitancia(){
        List<MilitanciaEntity> entities = militanciaRepository.findAll();
        Assert.notNull(entities, "FIND ALL MILITANCIA TEST");
    }

    @Test
    void findByIdMilitancia(){
        MilitanciaEntity entity = militanciaRepository.findById("mi1");
        Assert.notNull(entity, "FIND BY ID MILITANCIA TEST");
    }

    @Test
    void deleteMilitancia(){
        MilitanciaEntity entity = militanciaRepository.findById("mi1");
        boolean result = militanciaRepository.delete(entity);
        Assert.isTrue(result, "DELETE MILITANCIA TEST");
    }
}
