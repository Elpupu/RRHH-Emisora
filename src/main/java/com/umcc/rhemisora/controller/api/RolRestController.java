package com.umcc.rhemisora.controller.api;

import com.umcc.rhemisora.model.security.RolModel;
import com.umcc.rhemisora.service.security.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rol")
public class RolRestController implements IRestController<RolModel, String>{

    @Autowired
    private RolService service;

    @Override
    @GetMapping(name = "index_rol", path = "/")
    public ResponseEntity<List<RolModel>> index() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @Override
    @PostMapping(name = "new_rol", path = {"/new"})
    public void add(@RequestBody RolModel element) {
        service.add(element);
    }

    @Override
    @GetMapping(name = "show_rol", path = "/{id}")
    public ResponseEntity<RolModel> show(@PathVariable("id") String id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @Override
    @PutMapping(name = "edit_rol", path = {"/{id}/edit"})
    public void edit(@PathVariable("id") String id, @RequestBody RolModel element) {
        service.save(element);
    }

    @Override
    @DeleteMapping(name = "delete_rol", path = {"/{id}"})
    public void delete(@PathVariable("id") String id) {
        service.remove(id);
    }
}
