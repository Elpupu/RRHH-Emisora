package com.umcc.rhemisora.controller;

import com.umcc.rhemisora.config.Routes;
import com.umcc.rhemisora.model.Nivel_EscolaridadModel;
import com.umcc.rhemisora.model.PielModel;
import com.umcc.rhemisora.service.PielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("piel")
public class PielController {

    @Autowired
    private PielService pielService;

    @GetMapping("/")
    public ModelAndView index(){
        List<PielModel> pieles = pielService.getAll();
        ModelAndView index = new ModelAndView(Routes.PIEL_INDEX);
        index.addObject("pieles", pieles);
        return index;
    }

    @GetMapping("/new")
    public ModelAndView insertForm(){
        ModelAndView insertForm = new ModelAndView(Routes.PIEL_NEW);
        insertForm.addObject("piel", new PielModel());
        return insertForm;
    }

    @PostMapping ("/new")
    public RedirectView insert(@ModelAttribute PielModel piel, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/piel/", true);
        if (pielService.get(piel.getId_piel())==null && pielService.add(piel)){
            redirectAttributes.addFlashAttribute("message", "La piel se guardo correctamente");
            return redirectView;
        }else {
            redirectAttributes.addAttribute("message", "Error al guardar la piel");
            return new RedirectView("/piel/error-id");
        }
    }

    @GetMapping("/error-id")
    public ModelAndView error() {
        ModelAndView error = new ModelAndView(Routes.PIEL_ERROR);
        error.addObject("piel", new PielModel());
        return error;
    }

    @GetMapping("/{id_piel}/edit")
    public ModelAndView editForm(@PathVariable("id_piel") String id){
        PielModel piel = pielService.get(id);
        if (piel != null){
            ModelAndView edit = new ModelAndView(Routes.PIEL_EDIT);
            edit.addObject("piel", piel);
            return edit;
        }
        return null;
    }

    @PostMapping("/{id_piel}/edit")
    public RedirectView edit(@PathVariable("id_piel") String id, @ModelAttribute PielModel piel, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/piel/", true);
        piel.setId_piel(id);
        if (pielService.save(piel)){
            redirectAttributes.addFlashAttribute("message", "La piel se guardo correctamente");
        }else {
            redirectAttributes.addAttribute("message", "Error al guardar la piel");
        }
        return redirectView;
    }

    @GetMapping("/{id_piel}")
    public  ModelAndView show(@PathVariable("id_piel") String id){
        ModelAndView show = new ModelAndView(Routes.PIEL_SHOW);
        show.addObject("piel", pielService.get(id));
        return show;
    }

    @DeleteMapping("/{id_piel}")
    public void delete(@PathVariable("id_piel") String id){
        pielService.remove(id);
    }
}
