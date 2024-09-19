package com.umcc.rhemisora.controller;

import com.umcc.rhemisora.config.Routes;
import com.umcc.rhemisora.model.MilitanciaModel;
import com.umcc.rhemisora.model.Nivel_EscolaridadModel;
import com.umcc.rhemisora.service.Nivel_EscolaridadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("nivel_escolaridad")
public class Nivel_EscolaridadController {

    @Autowired
    private Nivel_EscolaridadService nivel_escolaridadService;

    @GetMapping("/")
    public ModelAndView index(){
        List<Nivel_EscolaridadModel> nivel_escolaridads = nivel_escolaridadService.getAll();
        ModelAndView index = new ModelAndView(Routes.NIVEL_ESCOLARIDAD_INDEX);
        index.addObject("nivel_escolaridads", nivel_escolaridads);
        return index;
    }

    @GetMapping("/new")
    public ModelAndView insertForm(){
        ModelAndView insertForm = new ModelAndView(Routes.NIVEL_ESCOLARIDAD_NEW);
        insertForm.addObject("nivel_escolaridad", new Nivel_EscolaridadModel());
        return insertForm;
    }

    @PostMapping ("/new")
    public RedirectView insert(@ModelAttribute Nivel_EscolaridadModel nivel_escolaridad, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/nivel_escolaridad/", true);
        if (nivel_escolaridadService.get(nivel_escolaridad.getId_ne())==null && nivel_escolaridadService.add(nivel_escolaridad)){
            redirectAttributes.addFlashAttribute("message", "El nivel de escolaridad se guardo correctamente");
            return redirectView;
        }else {
            redirectAttributes.addAttribute("message", "Error al guardar el nivel de escolaridad");
            return new RedirectView("/nivel_escolaridad/error-id");
        }
    }

    @GetMapping("/error-id")
    public ModelAndView error() {
        ModelAndView error = new ModelAndView(Routes.NIVEL_ESCOLARIDAD_ERROR);
        error.addObject("nivel_escolaridad", new Nivel_EscolaridadModel());
        return error;
    }

    @GetMapping("/{id_ne}/edit")
    public ModelAndView editForm(@PathVariable("id_ne") String id){
        Nivel_EscolaridadModel nivel_escolaridad = nivel_escolaridadService.get(id);
        if (nivel_escolaridad != null){
            ModelAndView edit = new ModelAndView(Routes.NIVEL_ESCOLARIDAD_EDIT);
            edit.addObject("nivel_escolaridad", nivel_escolaridad);
            return edit;
        }
        return null;
    }

    @PostMapping("/{id_ne}/edit")
    public RedirectView edit(@PathVariable("id_ne") String id, @ModelAttribute Nivel_EscolaridadModel nivel_escolaridad, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/nivel_escolaridad/", true);
        nivel_escolaridad.setId_ne(id);
        if (nivel_escolaridadService.save(nivel_escolaridad)){
            redirectAttributes.addFlashAttribute("message", "El nivel de escolaridad se guardo correctamente");
        }else {
            redirectAttributes.addAttribute("message", "Error al guardar el nivel de escolaridad");
        }
        return redirectView;
    }

    @GetMapping("/{id_ne}")
    public  ModelAndView show(@PathVariable("id_ne") String id) {
        ModelAndView show = new ModelAndView(Routes.NIVEL_ESCOLARIDAD_SHOW);
        show.addObject("nivel_escolaridad", nivel_escolaridadService.get(id));
        return show;
    }

    @DeleteMapping("/{id_ne}")
    public void delete(@PathVariable("id_ne") String id){
        nivel_escolaridadService.remove(id);
    }
}
