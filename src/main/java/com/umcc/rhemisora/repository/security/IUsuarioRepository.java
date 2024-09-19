package com.umcc.rhemisora.repository.security;

import com.umcc.rhemisora.entity.security.UsuarioEntity;
import com.umcc.rhemisora.repository.IBaseRepository;

public interface IUsuarioRepository extends IBaseRepository<UsuarioEntity, String> {

    public UsuarioEntity findByEmail(String correo);
}
