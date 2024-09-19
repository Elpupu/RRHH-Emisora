package com.umcc.rhemisora.controller;

import com.umcc.rhemisora.config.Routes;
import com.umcc.rhemisora.model.MunicipioModel;
import com.umcc.rhemisora.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("municipio")
public class MunicipioController {

    @Autowired
    private MunicipioService municipioService;

    @GetMapping("/")
    public ModelAndView index(){
        List<MunicipioModel> municipios = municipioService.getAll();
        ModelAndView index = new ModelAndView(Routes.MUNICIPIO_INDEX);
        index.addObject("municipios", municipios);
        return index;
    }

    @GetMapping("/new")
    public ModelAndView insertForm(){
        ModelAndView insertForm = new ModelAndView(Routes.MUNICIPIO_NEW);
        insertForm.addObject("municipio", new MunicipioModel());
        return insertForm;
    }

    @PostMapping ("/new")
    public RedirectView insert(@ModelAttribute MunicipioModel municipio, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/municipio/", true);
        if (municipioService.get(municipio.getId_mun())==null && municipioService.add(municipio)){
            redirectAttributes.addFlashAttribute("message", "El municipio se guardo correctamente");
            return redirectView;
        }else {
            redirectAttributes.addAttribute("message", "Error al guardar el municipio");
            return new RedirectView("/municipio/error-id");
        }
    }

    @GetMapping("/error-id")
    public ModelAndView error() {
        ModelAndView error = new ModelAndView(Routes.MUNICIPIO_ERROR);
        error.addObject("municipio", new MunicipioModel());
        return error;
    }

    @GetMapping("/{id_mun}/edit")
    public ModelAndView editForm(@PathVariable("id_mun") String id){
        MunicipioModel municipio = municipioService.get(id);
        if (municipio != null){
            ModelAndView edit = new ModelAndView(Routes.MUNICIPIO_EDIT);
            edit.addObject("municipio", municipio);
            return edit;
        }
        return null;
    }

    @PostMapping("/{id_mun}/edit")
    public RedirectView edit(@PathVariable("id_mun") String id, @ModelAttribute MunicipioModel municipio, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/municipio/", true);
        municipio.setId_mun(id);
        if (municipioService.save(municipio)){
            redirectAttributes.addFlashAttribute("message", "El municipio se guardo correctamente");
        }else {
            redirectAttributes.addAttribute("message", "Error al guardar el municipio");
        }
        return redirectView;
    }

    @GetMapping("/{id_mun}")
    public  ModelAndView show(@PathVariable("id_mun") String id){
        ModelAndView show = new ModelAndView(Routes.MUNICIPIO_SHOW);
        show.addObject("municipio", municipioService.get(id));
        return show;
    }

    @DeleteMapping("/{id_mun}")
    public void delete(@PathVariable("id_mun") String id){
        municipioService.remove(id);
    }
}
