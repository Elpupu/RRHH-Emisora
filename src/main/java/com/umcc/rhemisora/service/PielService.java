package com.umcc.rhemisora.service;

import com.umcc.rhemisora.mapper.PielMapper;
import com.umcc.rhemisora.model.PielModel;
import com.umcc.rhemisora.repository.PielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PielService implements IPielService {

    @Autowired
    private PielRepository pielRepository;

    @Override
    public List<PielModel> getAll() {
        return pielRepository.findAll().stream().map(PielMapper::mapToModel).collect(Collectors.toList());
    }

    @Override
    public PielModel get(String id) {
        return PielMapper.mapToModel(pielRepository.findById(id));
    }

    @Override
    public boolean save(PielModel element) {
        return pielRepository.update(PielMapper.mapToEntity(element));
    }

    @Override
    public boolean add(PielModel element) {
        return pielRepository.save(PielMapper.mapToEntity(element));
    }

    @Override
    public boolean remove(String id) {
        return pielRepository.delete(pielRepository.findById(id));
    }
}
