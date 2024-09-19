package com.umcc.rhemisora.controller.api;

import com.umcc.rhemisora.model.security.UsuarioModel;
import com.umcc.rhemisora.service.security.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioRestController implements IRestController<UsuarioModel, String>{

    @Autowired
    private UsuarioService service;

    @Override
    @GetMapping(name = "index_usuario", path = "/")
    public ResponseEntity<List<UsuarioModel>> index() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @Override
    @PostMapping(name = "new_usuario", path = {"/new"})
    public void add(@RequestBody UsuarioModel element) {
        service.add(element);
    }

    @Override
    @GetMapping(name = "show_usuario", path = "/{id}")
    public ResponseEntity<UsuarioModel> show(@PathVariable("id") String id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @Override
    @PutMapping(name = "edit_usuario", path = {"/{id}/edit"})
    public void edit(@PathVariable("id") String id, @RequestBody UsuarioModel element) {
        service.save(element);
    }

    @Override
    @DeleteMapping(name = "delete_usuario", path = {"/{id}"})
    public void delete(@PathVariable("id") String id) {
        service.remove(id);
    }
}
