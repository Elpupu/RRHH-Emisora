package com.umcc.rhemisora.service;

import com.umcc.rhemisora.mapper.Nivel_EscolaridadMapper;
import com.umcc.rhemisora.model.Nivel_EscolaridadModel;
import com.umcc.rhemisora.repository.Nivel_EscolaridadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Nivel_EscolaridadService implements INivel_EscolaridadService {

    @Autowired
    private Nivel_EscolaridadRepository nivelEscolaridadRepository;

    @Override
    public List<Nivel_EscolaridadModel> getAll() {
        return nivelEscolaridadRepository.findAll().stream().map(Nivel_EscolaridadMapper::mapToModel).collect(Collectors.toList());
    }

    @Override
    public Nivel_EscolaridadModel get(String id) {
        return Nivel_EscolaridadMapper.mapToModel(nivelEscolaridadRepository.findById(id));
    }

    @Override
    public boolean save(Nivel_EscolaridadModel element) {
        return nivelEscolaridadRepository.update(Nivel_EscolaridadMapper.mapToEntity(element));
    }

    @Override
    public boolean add(Nivel_EscolaridadModel element) {
        return nivelEscolaridadRepository.save(Nivel_EscolaridadMapper.mapToEntity(element));
    }

    @Override
    public boolean remove(String id) {
        return nivelEscolaridadRepository.delete(nivelEscolaridadRepository.findById(id));
    }
}
