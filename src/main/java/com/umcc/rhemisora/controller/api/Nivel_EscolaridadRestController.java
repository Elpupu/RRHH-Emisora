package com.umcc.rhemisora.controller.api;

import com.umcc.rhemisora.model.Nivel_EscolaridadModel;
import com.umcc.rhemisora.service.Nivel_EscolaridadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/nivel_escolaridad")
public class Nivel_EscolaridadRestController implements IRestController<Nivel_EscolaridadModel, String> {

    @Autowired
    private Nivel_EscolaridadService service;

    @Override
    @GetMapping(name = "index_nivel_escolaridad", path = "/")
    public ResponseEntity<List<Nivel_EscolaridadModel>> index() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @Override
    @PostMapping(name = "new_nivel_escolaridad", path = {"/new"})
    public void add(@RequestBody Nivel_EscolaridadModel nivel_escolaridad) {
        service.add(nivel_escolaridad);
    }

    @Override
    @GetMapping(name = "show_nivel_escolaridad", path = "/{id}")
    public ResponseEntity<Nivel_EscolaridadModel> show(@PathVariable("id") String id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @Override
    @PutMapping(name = "edit_nivel_escolaridad", path = {"/{id}/edit"})
    public void edit(@PathVariable("id") String id, @RequestBody Nivel_EscolaridadModel nivel_escolaridad) {
        service.save(nivel_escolaridad);
    }

    @Override
    @DeleteMapping(name = "delete_nivel_escolaridad", path = {"/{id}"})
    public void delete(@PathVariable("id") String id) {
        service.remove(id);
    }
}
