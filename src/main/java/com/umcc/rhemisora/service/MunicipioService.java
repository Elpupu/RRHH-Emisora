package com.umcc.rhemisora.service;

import com.umcc.rhemisora.mapper.MunicipioMapper;
import com.umcc.rhemisora.model.MunicipioModel;
import com.umcc.rhemisora.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class MunicipioService implements IMunicipioService{

    @Autowired
    private MunicipioRepository municipioRepository;

    @Override
    public List<MunicipioModel> getAll() {
        return municipioRepository.findAll().stream().map(MunicipioMapper::mapToModel).collect(Collectors.toList());
    }

    @Override
    public MunicipioModel get(String id) {
        return MunicipioMapper.mapToModel(municipioRepository.findById(id));
    }

    @Override
    public boolean save(MunicipioModel element) {
        return municipioRepository.update(MunicipioMapper.mapToEntity(element));
    }

    @Override
    public boolean add(MunicipioModel element) {
        return municipioRepository.save(MunicipioMapper.mapToEntity(element));
    }

    @Override
    public boolean remove(String id) {
        return municipioRepository.delete(municipioRepository.findById(id));
    }
}
