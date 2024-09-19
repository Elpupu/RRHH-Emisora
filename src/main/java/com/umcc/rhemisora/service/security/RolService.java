package com.umcc.rhemisora.service.security;

import com.umcc.rhemisora.mapper.security.RolMapper;
import com.umcc.rhemisora.model.security.RolModel;
import com.umcc.rhemisora.repository.security.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolService implements IRolService{

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<RolModel> getAll() {
        return  rolRepository.findAll().stream().map(RolMapper::mapToModel).collect(Collectors.toList());
    }

    @Override
    public RolModel get(String id) {
        return RolMapper.mapToModel(rolRepository.findById(id));
    }

    @Override
    public boolean save(RolModel element) {
        return rolRepository.update(RolMapper.mapToEntity(element));
    }

    @Override
    public boolean add(RolModel element) {
        return rolRepository.save(RolMapper.mapToEntity(element));
    }

    @Override
    public boolean remove(String id) {
        return rolRepository.delete(rolRepository.findById(id));
    }
}
