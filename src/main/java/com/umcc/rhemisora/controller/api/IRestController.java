package com.umcc.rhemisora.controller.api;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IRestController<T, Y> {

    public ResponseEntity<List<T>> index();

    public void add(T element);

    public ResponseEntity<T> show(Y id);

    public void edit(Y id, T element);

    public void delete(Y id);
}
