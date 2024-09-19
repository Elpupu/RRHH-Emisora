package com.umcc.rhemisora.controller.api;

import com.umcc.rhemisora.model.MilitanciaModel;
import com.umcc.rhemisora.service.MilitanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/militancia")
public class MilitanciaRestController implements IRestController<MilitanciaModel, String> {

    @Autowired
    private MilitanciaService service;

    @Override
    @GetMapping(name = "index_militancia", path = "/")
    public ResponseEntity<List<MilitanciaModel>> index() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @Override
    @PostMapping(name = "new_militancia", path = {"/new"})
    public void add(@RequestBody MilitanciaModel militancia) {

        service.add(militancia);
    }

    @Override
    @GetMapping(name = "show_militancia", path = "/{id}")
    public ResponseEntity<MilitanciaModel> show(@PathVariable("id") String id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @Override
    @PutMapping(name = "edit_militancia", path = {"/{id}/edit"})
    public void edit(@PathVariable("id") String id, @RequestBody MilitanciaModel militancia) {
        service.save(militancia);
    }

    @Override
    @DeleteMapping(name = "delete_militancia", path = {"/{id}"})
    public void delete(@PathVariable("id") String id) {

        service.remove(id);
    }
}
