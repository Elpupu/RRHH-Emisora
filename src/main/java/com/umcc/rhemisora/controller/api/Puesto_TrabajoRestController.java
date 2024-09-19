package com.umcc.rhemisora.controller.api;

import com.umcc.rhemisora.model.Puesto_TrabajoModel;
import com.umcc.rhemisora.service.Puesto_TrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/puesto_trabajo")
public class Puesto_TrabajoRestController implements IRestController<Puesto_TrabajoModel, String> {

    @Autowired
    private Puesto_TrabajoService service;

    @Override
    @GetMapping(name = "index_puesto_trabajo", path = "/")
    public ResponseEntity<List<Puesto_TrabajoModel>> index() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @Override
    @PostMapping(name = "new_puesto_trabajo", path = {"/new"})
    public void add(@RequestBody Puesto_TrabajoModel puesto_trabajo) {
        service.add(puesto_trabajo);
    }

    @Override
    @GetMapping(name = "show_puesto_trabajo", path = "/{id}")
    public ResponseEntity<Puesto_TrabajoModel> show(@PathVariable("id") String id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @Override
    @PutMapping(name = "edit_puesto_trabajo", path = {"/{id}/edit"})
    public void edit(@PathVariable("id") String id, @RequestBody Puesto_TrabajoModel puesto_trabajo) {
        service.save(puesto_trabajo);
    }

    @Override
    @DeleteMapping(name = "delete_puesto_trabajo", path = {"/{id}"})
    public void delete(@PathVariable("id") String id) {
        service.remove(id);
    }
}
