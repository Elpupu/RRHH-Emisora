package com.umcc.rhemisora.controller.api;

import com.umcc.rhemisora.model.MunicipioModel;
import com.umcc.rhemisora.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/municipio")
public class MunicipioRestController implements IRestController<MunicipioModel, String> {

    @Autowired
    private MunicipioService service;

    @Override
    @GetMapping(name = "index_municipio", path = "/")
    public ResponseEntity<List<MunicipioModel>> index() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @Override
    @PostMapping(name = "new_municipio", path = {"/new"})
    public void add(@RequestBody MunicipioModel municipio) {
        service.add(municipio);
    }

    @Override
    @GetMapping(name = "show_municipio", path = "/{id}")
    public ResponseEntity<MunicipioModel> show(@PathVariable("id") String id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @Override
    @PutMapping(name = "edit_municipio", path = {"/{id}/edit"})
    public void edit(@PathVariable("id") String id, @RequestBody MunicipioModel municipio) {
        service.save(municipio);
    }


    @Override
    @DeleteMapping(name = "delete_municipio", path = {"/{id}"})
    public void delete(@PathVariable("id") String id) {
        service.remove(id);
    }
}
