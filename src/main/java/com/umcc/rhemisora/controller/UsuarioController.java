package com.umcc.rhemisora.controller;

import com.umcc.rhemisora.config.Routes;
import com.umcc.rhemisora.model.security.RolModel;
import com.umcc.rhemisora.model.security.UsuarioModel;
import com.umcc.rhemisora.service.security.RolService;
import com.umcc.rhemisora.service.security.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("usuario")
@PreAuthorize("hasRole('ADMIN')")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @GetMapping("/")
    public ModelAndView index(){
        List<UsuarioModel> usuarios = usuarioService.getAll();
        ModelAndView index = new ModelAndView(Routes.USUARIO_INDEX);
        index.addObject("usuarios", usuarios);
        return index;
    }
    @GetMapping("/new")
    public ModelAndView insertForm(){
        ModelAndView insertForm = new ModelAndView(Routes.USUARIO_NEW);
        insertForm.addObject("usuario", new UsuarioModel());
        insertForm.addObject("rols", rolService.getAll());
        return insertForm;
    }
    @PostMapping("/new")
    public RedirectView insert(@ModelAttribute UsuarioModel usuario, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/usuario/", true);
        if (usuarioService.get(usuario.getId_usuario())==null && usuarioService.add(usuario)){
            redirectAttributes.addFlashAttribute("message", "El usuario se guardo correctamente");
            return redirectView;
        }else {
            redirectAttributes.addAttribute("message", "Error al guardar el usuario");
            return new RedirectView("/usuario/error-id");
        }
    }

    @GetMapping("/error-id")
    public ModelAndView error() {
        ModelAndView error = new ModelAndView(Routes.USUARIO_ERROR);
        error.addObject("usuario", new UsuarioModel());
        return error;
    }

    @GetMapping("/{id_usuario}/edit")
    public ModelAndView editForm(@PathVariable("id_usuario") String id){
        UsuarioModel usuario = usuarioService.get(id);
        if (usuario != null){
            ModelAndView edit = new ModelAndView(Routes.USUARIO_EDIT);
            edit.addObject("usuario", usuario);
            edit.addObject("rols", rolService.getAll());
            return edit;
        }
        return null;
    }

    @PostMapping("/{id_usuario}/edit")
    public RedirectView edit(@PathVariable("id_usuario") String id, @ModelAttribute UsuarioModel usuario, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/usuario/", true);
        usuario.setId_usuario(id);
        if (usuarioService.save(usuario)){
            redirectAttributes.addFlashAttribute("message", "El usuario se guardo correctamente");
        }else {
            redirectAttributes.addAttribute("message", "Error al guardar el usuario");
        }
        return redirectView;
    }

    @GetMapping("/{id_usuario}")
    public  ModelAndView show(@PathVariable("id_usuario") String id){
        ModelAndView show = new ModelAndView(Routes.USUARIO_SHOW);
        show.addObject("usuario", usuarioService.get(id));
        return show;
    }

    @DeleteMapping("/{id_usuario}")
    public void delete(@PathVariable("id_usuario") String id){
        usuarioService.remove(id);
    }

}
