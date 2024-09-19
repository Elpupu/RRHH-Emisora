package com.umcc.rhemisora.controller;

import com.umcc.rhemisora.config.Routes;
import com.umcc.rhemisora.model.Puesto_TrabajoModel;
import com.umcc.rhemisora.model.security.RolModel;
import com.umcc.rhemisora.service.security.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("rol")
@PreAuthorize("hasRole('ADMIN')")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/")
    public ModelAndView index(){
        List<RolModel> rols = rolService.getAll();
        ModelAndView index = new ModelAndView(Routes.ROL_INDEX);
        index.addObject("rols", rols);
        return index;
    }
    @GetMapping("/new")
    public ModelAndView insertForm(){
        ModelAndView insertForm = new ModelAndView(Routes.ROL_NEW);
        insertForm.addObject("rol", new RolModel());
        return insertForm;
    }

    @PostMapping("/new")
    public RedirectView insert(@ModelAttribute RolModel rol, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/rol/", true);
        if (rolService.get(rol.getId_rol())==null && rolService.add(rol)){
            redirectAttributes.addFlashAttribute("message", "El rol se guardo correctamente");
            return redirectView;
        }else {
            redirectAttributes.addAttribute("message", "Error al guardar el rol");
            return new RedirectView("/rol/error-id");
        }
    }

    @GetMapping("/error-id")
    public ModelAndView error() {
        ModelAndView error = new ModelAndView(Routes.ROl_ERROR);
        error.addObject("rol", new RolModel());
        return error;
    }


    @GetMapping("/{id_rol}/edit")
    public ModelAndView editForm(@PathVariable("id_rol") String id){
        RolModel rol = rolService.get(id);
        if (rol != null){
            ModelAndView edit = new ModelAndView(Routes.ROL_EDIT);
            edit.addObject("rol", rol);
            return edit;
        }
        return null;
    }

    @PostMapping("/{id_rol}/edit")
    public RedirectView edit(@PathVariable("id_rol") String id, @ModelAttribute RolModel rol, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/rol/", true);
        rol.setId_rol(id);
        if (rolService.save(rol)){
            redirectAttributes.addFlashAttribute("message", "El rol se guardo correctamente");
        }else {
            redirectAttributes.addAttribute("message", "Error al guardar el rol");
        }
        return redirectView;
    }

    @GetMapping("/{id_rol}")
    public  ModelAndView show(@PathVariable("id_rol") String id){
        ModelAndView show = new ModelAndView(Routes.ROl_SHOW);
        show.addObject("rol", rolService.get(id));
        return show;
    }
    @DeleteMapping("/{id_rol}")
    public void delete(@PathVariable("id_rol") String id){
        rolService.remove(id);
    }

}
