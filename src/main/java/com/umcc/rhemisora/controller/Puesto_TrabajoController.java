package com.umcc.rhemisora.controller;

import com.umcc.rhemisora.config.Routes;
import com.umcc.rhemisora.model.PielModel;
import com.umcc.rhemisora.model.Puesto_TrabajoModel;
import com.umcc.rhemisora.service.Puesto_TrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("puesto_trabajo")
public class Puesto_TrabajoController {

    @Autowired
    private Puesto_TrabajoService puesto_trabajoService;

    @GetMapping("/")
    public ModelAndView index(){
        List<Puesto_TrabajoModel> puesto_trabajos = puesto_trabajoService.getAll();
        ModelAndView index = new ModelAndView(Routes.PUESTO_TRABAJO_INDEX);
        index.addObject("puesto_trabajos", puesto_trabajos);
        return index;
    }

    @GetMapping("/new")
    public ModelAndView insertForm(){
        ModelAndView insertForm = new ModelAndView(Routes.PUESTO_TRABAJO_NEW);
        insertForm.addObject("puesto_trabajo", new Puesto_TrabajoModel());
        return insertForm;
    }

    @PostMapping ("/new")
    public RedirectView insert(@ModelAttribute Puesto_TrabajoModel puesto_trabajo, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/puesto_trabajo/", true);
        if (puesto_trabajoService.get(puesto_trabajo.getId_puest())==null && puesto_trabajoService.add(puesto_trabajo)){
            redirectAttributes.addFlashAttribute("message", "El puesto de trabajo se guardo correctamente");
            return redirectView;
        }else {
            redirectAttributes.addAttribute("message", "Error al guardar el puesto de trabajo");
            return new RedirectView("/puesto_trabajo/error-id");
        }
    }

    @GetMapping("/error-id")
    public ModelAndView error() {
        ModelAndView error = new ModelAndView(Routes.PUESTO_TRABAJO_ERROR);
        error.addObject("puesto_trabajo", new Puesto_TrabajoModel());
        return error;
    }

    @GetMapping("/{id_puest}/edit")
    public ModelAndView editForm(@PathVariable("id_puest") String id){
        Puesto_TrabajoModel puesto_trabajo = puesto_trabajoService.get(id);
        if (puesto_trabajo != null){
            ModelAndView edit = new ModelAndView(Routes.PUESTO_TRABAJO_EDIT);
            edit.addObject("puesto_trabajo", puesto_trabajo);
            return edit;
        }
        return null;
    }

    @PostMapping("/{id_puest}/edit")
    public RedirectView edit(@PathVariable("id_puest") String id, @ModelAttribute Puesto_TrabajoModel puesto_trabajo, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/puesto_trabajo/", true);
        puesto_trabajo.setId_puest(id);
        if (puesto_trabajoService.save(puesto_trabajo)){
            redirectAttributes.addFlashAttribute("message", "El puesto de trabajo se guardo correctamente");
        }else {
            redirectAttributes.addAttribute("message", "Error al guardar el puesto de trabajo");
        }
        return redirectView;
    }

    @GetMapping("/{id_puest}")
    public  ModelAndView show(@PathVariable("id_puest") String id){
        ModelAndView show = new ModelAndView(Routes.PUESTO_TRABAJO_SHOW);
        show.addObject("puesto_trabajo", puesto_trabajoService.get(id));
        return show;
    }

    @DeleteMapping("/{id_puest}")
    public void delete(@PathVariable("id_puest") String id){
        puesto_trabajoService.remove(id);
    }
}
