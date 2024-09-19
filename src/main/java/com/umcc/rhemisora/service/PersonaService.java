package com.umcc.rhemisora.service;

import com.umcc.rhemisora.mapper.PersonaMapper;
import com.umcc.rhemisora.model.PersonaModel;
import com.umcc.rhemisora.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;


    @Override
    public List<PersonaModel> getAll() {
        return personaRepository.findAll().stream().map(PersonaMapper::mapToModel).collect(Collectors.toList());
    }

    @Override
    public PersonaModel get(String id) {
        return PersonaMapper.mapToModel(personaRepository.findById(id));
    }

    @Override
    public boolean save(PersonaModel element) {

        return personaRepository.update(PersonaMapper.mapToEntity(element));
    }

    @Override
    public boolean add(PersonaModel element) {

        return personaRepository.save(PersonaMapper.mapToEntity(element));
    }

    @Override
    public boolean remove(String id) {

        return personaRepository.delete(personaRepository.findById(id));
    }
}
