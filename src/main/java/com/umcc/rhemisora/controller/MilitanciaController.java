package com.umcc.rhemisora.controller;

import com.umcc.rhemisora.config.Routes;
import com.umcc.rhemisora.model.MilitanciaModel;
import com.umcc.rhemisora.model.MunicipioModel;
import com.umcc.rhemisora.service.MilitanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("militancia")
public class MilitanciaController {

    @Autowired
    private MilitanciaService militanciaService;

    @GetMapping("/")
    public ModelAndView index(){
        List<MilitanciaModel> militancias = militanciaService.getAll();
        ModelAndView index = new ModelAndView(Routes.MILITANCIA_INDEX);
        index.addObject("militancias", militancias);
        return index;
    }

    @GetMapping("/new")
    public ModelAndView insertForm(){
        ModelAndView insertForm = new ModelAndView(Routes.MILITANCIA_NEW);
        insertForm.addObject("militancia", new MilitanciaModel());
        return insertForm;
    }

    @PostMapping ("/new")
    public RedirectView insert(@ModelAttribute MilitanciaModel militancia, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/militancia/", true);
        if (militanciaService.get(militancia.getId_milit())==null && militanciaService.add(militancia)){
            redirectAttributes.addFlashAttribute("message", "La militancia se guardo correctamente");
            return redirectView;
        }else {
            redirectAttributes.addAttribute("message", "Error al guardar la militancia");
            return new RedirectView("/militancia/error-id");
        }
    }

    @GetMapping("/error-id")
    public ModelAndView error() {
        ModelAndView error = new ModelAndView(Routes.MILITANCIA_ERROR);
        //error.addObject("militancia", new MilitanciaModel());
        return error;
    }

    @GetMapping("/{id_milit}/edit")
    public ModelAndView editForm(@PathVariable("id_milit") String id){
        MilitanciaModel militancia = militanciaService.get(id);
        if (militancia != null){
            ModelAndView edit = new ModelAndView(Routes.MILITANCIA_EDIT);
            edit.addObject("militancia", militancia);
            return edit;
        }
        return null;
    }

    @PostMapping("/{id_milit}/edit")
    public RedirectView edit(@PathVariable("id_milit") String id, @ModelAttribute MilitanciaModel militancia, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/militancia/", true);
        militancia.setId_milit(id);
        if (militanciaService.save(militancia)){
            redirectAttributes.addFlashAttribute("message", "La militancia se guardo correctamente");
        }else {
            redirectAttributes.addAttribute("message", "Error al guardar la militancia");
        }
        return redirectView;
    }

    @GetMapping("/{id_milit}")
    public  ModelAndView show(@PathVariable("id_milit") String id){
        ModelAndView show = new ModelAndView(Routes.MILITANCIA_SHOW);
        show.addObject("militancia", militanciaService.get(id));
        return show;
    }

    @DeleteMapping("/{id_milit}")
    public void delete(@PathVariable("id_milit") String id){
        militanciaService.remove(id);
    }
}
