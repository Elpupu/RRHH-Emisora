package com.umcc.rhemisora.service.security;

import com.umcc.rhemisora.model.security.UsuarioModel;
import com.umcc.rhemisora.service.IBaseService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUsuarioService extends IBaseService<UsuarioModel, String>, UserDetailsService {
}
