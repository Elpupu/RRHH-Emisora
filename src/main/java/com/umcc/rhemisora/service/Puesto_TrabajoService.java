package com.umcc.rhemisora.service;

import com.umcc.rhemisora.mapper.Puesto_TrabajoMapper;
import com.umcc.rhemisora.model.Puesto_TrabajoModel;
import com.umcc.rhemisora.repository.Puesto_TrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Puesto_TrabajoService implements IPuesto_TrabajoService {
    @Autowired
    private Puesto_TrabajoRepository puestoTrabajoRepository;

    @Override
    public List<Puesto_TrabajoModel> getAll() {
        return puestoTrabajoRepository.findAll().stream().map(Puesto_TrabajoMapper::mapToModel).collect(Collectors.toList());
    }

    @Override
    public Puesto_TrabajoModel get(String id) {
        return Puesto_TrabajoMapper.mapToModel(puestoTrabajoRepository.findById(id));
    }

    @Override
    public boolean save(Puesto_TrabajoModel element) {
        return puestoTrabajoRepository.update(Puesto_TrabajoMapper.mapToEntity(element));
    }

    @Override
    public boolean add(Puesto_TrabajoModel element) {
        return puestoTrabajoRepository.save(Puesto_TrabajoMapper.mapToEntity(element));
    }

    @Override
    public boolean remove(String id) {
        return puestoTrabajoRepository.delete(puestoTrabajoRepository.findById(id));
    }
}
