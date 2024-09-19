package com.umcc.rhemisora.controller.api;

import com.umcc.rhemisora.model.PielModel;
import com.umcc.rhemisora.service.PielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/piel")
public class PielRestController implements IRestController<PielModel, String> {

    @Autowired
    private PielService service;

    @Override
    @GetMapping(name = "index_piel", path = "/")
    public ResponseEntity<List<PielModel>> index() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @Override
    @PostMapping(name = "new_piel", path = {"/new"})
    public void add(@RequestBody PielModel piel) {
        service.add(piel);
    }

    @Override
    @GetMapping(name = "show_piel", path = "/{id}")
    public ResponseEntity<PielModel> show(@PathVariable("id") String id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @Override
    @PutMapping(name = "edit_piel", path = {"/{id}/edit"})
    public void edit(@PathVariable("id") String id, @RequestBody PielModel piel) {
        service.save(piel);
    }

    @Override
    @DeleteMapping(name = "delete_piel", path = {"/{id}"})
    public void delete(@PathVariable("id") String id) {
        service.remove(id);
    }
}
