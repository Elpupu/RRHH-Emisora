package com.umcc.rhemisora.controller;

import com.umcc.rhemisora.config.Routes;
import com.umcc.rhemisora.model.*;
import com.umcc.rhemisora.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;
    @Autowired
    private MunicipioService municipioService;
    @Autowired
    private PielService pielService;
    @Autowired
    private MilitanciaService militanciaService;
    @Autowired
    private Nivel_EscolaridadService nivel_escolaridadService;

    @Autowired Puesto_TrabajoService puestoTrabajoService;

    @GetMapping("/")
    public ModelAndView index(){
        List<PersonaModel> personas = personaService.getAll();
        ModelAndView index = new ModelAndView(Routes.PERSONA_INDEX);
        index.addObject("personas", personas);
        return index;
    }

    @GetMapping("/new")
    public ModelAndView insertForm(){
        ModelAndView insertForm = new ModelAndView(Routes.PERSONA_NEW);
        insertForm.addObject("persona", new PersonaModel());
        insertForm.addObject("municipios", municipioService.getAll());
        insertForm.addObject("piels", pielService.getAll());
        insertForm.addObject("nivel_escolaridads", nivel_escolaridadService.getAll());
        insertForm.addObject("militancias", militanciaService.getAll());
        insertForm.addObject("puesto_trabajos", puestoTrabajoService.getAll());
        return insertForm;
    }

    @PostMapping ("/new")
    public RedirectView insert(@ModelAttribute PersonaModel persona, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/persona/", true);
        if (personaService.get(persona.getCi())==null && personaService.add(persona)){
            redirectAttributes.addFlashAttribute("message", "La persona se guardo correctamente");
            return redirectView;
        }else {
            redirectAttributes.addAttribute("message", "Error al guardar La persona");
            return new RedirectView("/persona/error-id");
        }
    }

    @GetMapping("/error-id")
    public ModelAndView error(){
        ModelAndView error = new ModelAndView(Routes.PERSONA_ERROR);
        /*error.addObject("persona", new PersonaModel());
        error.addObject("municipios", municipioService.getAll());
        error.addObject("piels", pielService.getAll());
        error.addObject("nivel_escolaridads", nivel_escolaridadService.getAll());
        error.addObject("militancias", militanciaService.getAll());
        error.addObject("puesto_trabajos", puestoTrabajoService.getAll());*/
        return error;
    }

    @GetMapping("/{ci}/edit")
    public ModelAndView editForm(@PathVariable("ci") String id){
        PersonaModel persona = personaService.get(id);
        if (persona != null){
            ModelAndView edit = new ModelAndView(Routes.PERSONA_EDIT);
            edit.addObject("persona", persona);
            edit.addObject("municipios", municipioService.getAll());
            edit.addObject("piels", pielService.getAll());
            edit.addObject("nivel_escolaridads", nivel_escolaridadService.getAll());
            edit.addObject("militancias", militanciaService.getAll());
            edit.addObject("puesto_trabajos", puestoTrabajoService.getAll());
            return edit;
        }
        return null;
    }

    @PostMapping("/{ci}/edit")
    public RedirectView edit(@PathVariable("ci") String id, @ModelAttribute PersonaModel persona, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/persona/", true);
        persona.setCi(id);
        if (personaService.save(persona)){
            redirectAttributes.addFlashAttribute("message", "La persona se guardo correctamente");
        }else {
            redirectAttributes.addAttribute("message", "Error al guardar la persona");
        }
        return redirectView;
    }

    @GetMapping("/{ci}")
    public  ModelAndView show(@PathVariable("ci") String id){
        ModelAndView show = new ModelAndView(Routes.PERSONA_SHOW);
        show.addObject("persona", personaService.get(id));
        return show;
    }

    @DeleteMapping("/{ci}")
    public void delete(@PathVariable("ci") String id){
        personaService.remove(id);
    }
}
