package com.umcc.rhemisora.repository;

import com.umcc.rhemisora.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class PersonaRepositoryTest {

    @Autowired
    private PersonaRepository personaRepository;

    @Test
    public void insertPersona() {
        PersonaEntity entity = new PersonaEntity();
        entity.setCi("01");
        //entity.setSexo(true);
        entity.setNombre_persona("pedro");
        //entity.setDireccion("minerva");
        entity.setApellido1("lazaro");
        //entity.setCelular("5555");
        entity.setApellido2("rodrig");
       // entity.setTelefono_fijo("4552");
        entity.setMunicipio(new MunicipioEntity("m1","card"));
        entity.setMilitancia(new MilitanciaEntity("mili1","mon"));
        entity.setPiel(new PielEntity("p1","neg"));
        entity.setNivel_escolaridad(new Nivel_EscolaridadEntity("n1","secu"));
        boolean result = personaRepository.save(entity);
        Assert.isTrue(result, "INSERT PERSONA TEST");
    }

    @Test
    void updatePersona() {
        PersonaEntity entity = new PersonaEntity();
        entity.setCi("01");
        //entity.setSexo(true);
        entity.setNombre_persona("pedro update");
       // entity.setDireccion("minerva");
        entity.setApellido1("lazaro");
       // entity.setCelular("5555");
        entity.setApellido2("rodrig");
      //  entity.setTelefono_fijo("4552");
        /*entity.setId_mun("m1");
        entity.setId_milit("mi1");
        entity.setId_piel("p1");
        entity.setId_ne("n1");*/
        boolean result = personaRepository.update(entity);
        Assert.isTrue(result, "UPDATE PERSONA TEST");
    }

    @Test
    void findAllPersona() {
        List<PersonaEntity> entities = personaRepository.findAll();
        Assert.notNull(entities, "FIND ALL PERSONA TEST");
    }

    @Test
    void findByIdPersona() {
        PersonaEntity entity = personaRepository.findById("01");
        Assert.notNull(entity, "FIND BY ID PERSONA TEST");
    }

    @Test
    void deletePersona() {
        PersonaEntity entity = personaRepository.findById("01");
        boolean result = personaRepository.delete(entity);
        Assert.isTrue(result, "DELETE PERSONA TEST");
    }
}
