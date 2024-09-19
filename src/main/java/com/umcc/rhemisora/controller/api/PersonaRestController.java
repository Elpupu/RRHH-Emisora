package com.umcc.rhemisora.controller.api;

import com.umcc.rhemisora.model.PersonaModel;
import com.umcc.rhemisora.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/persona")
public class PersonaRestController implements IRestController<PersonaModel, String> {

    @Autowired
    private PersonaService service;

    @Override
    @GetMapping(name = "index_persona", path = "/")
    public ResponseEntity<List<PersonaModel>> index() {

        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @Override
    @PostMapping(name = "new_persona", path = {"/new"})
    public void add(@RequestBody PersonaModel persona) {

        service.add(persona);
    }

    @Override
    @GetMapping(name = "show_persona", path = "/{id}")
    public ResponseEntity<PersonaModel> show(@PathVariable("id") String id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @Override
    @PutMapping(name = "edit_persona", path = {"/{id}/edit"})
    public void edit(@PathVariable("id") String id, @RequestBody PersonaModel persona) {
        service.save(persona);
    }

    @Override
    @DeleteMapping(name = "delete_persona", path = {"/{id}"})
    public void delete(@PathVariable("id") String id) {
        service.remove(id);
    }
}
