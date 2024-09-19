package com.umcc.rhemisora.service.security;

import com.umcc.rhemisora.entity.security.UsuarioEntity;
import com.umcc.rhemisora.mapper.security.UsuarioMapper;
import com.umcc.rhemisora.model.security.UsuarioModel;
import com.umcc.rhemisora.repository.security.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements IUsuarioService{

    @Bean
    public PasswordEncoder codificarClave(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioModel> getAll() {
        return usuarioRepository.findAll().stream().map(UsuarioMapper::mapToModel).collect(Collectors.toList());
    }

    @Override
    public UsuarioModel get(String id) {
        return UsuarioMapper.mapToModel(usuarioRepository.findById(id));
    }

    @Override
    public boolean save(UsuarioModel element) {
        return usuarioRepository.update(UsuarioMapper.mapToEntity(element));
    }

    @Override
    public boolean add(UsuarioModel element) {
        element.setClave(codificarClave().encode(element.getClave()));
        return usuarioRepository.save(UsuarioMapper.mapToEntity(element));
    }

    @Override
    public boolean remove(String id) {
        return usuarioRepository.delete(usuarioRepository.findById(id));
    }

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        UsuarioEntity usuario = usuarioRepository.findByEmail(correo);
        GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol().getNombre_rol());
        return new org.springframework.security.core.userdetails.User(
                usuario.getCorreo(),
                usuario.getClave(),
                Set.of(authority)
        );
    }

}
