package com.umcc.rhemisora.service;

import com.umcc.rhemisora.mapper.MilitanciaMapper;
import com.umcc.rhemisora.model.MilitanciaModel;
import com.umcc.rhemisora.repository.MilitanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MilitanciaService implements IMilitanciaService{

    @Autowired
    private MilitanciaRepository militanciaRepository;

    @Override
    public List<MilitanciaModel> getAll() {
        return  militanciaRepository.findAll().stream().map(MilitanciaMapper::mapToModel).collect(Collectors.toList());
    }

    @Override
    public MilitanciaModel get(String id) {

        return MilitanciaMapper.mapToModel(militanciaRepository.findById(id));
    }

    @Override
    public boolean save(MilitanciaModel element) {
        return militanciaRepository.update(MilitanciaMapper.mapToEntity(element));
    }

    @Override
    public boolean add(MilitanciaModel element) {
        return militanciaRepository.save(MilitanciaMapper.mapToEntity(element));
    }

    @Override
    public boolean remove(String id) {

        return militanciaRepository.delete(militanciaRepository.findById(id));
    }
}
