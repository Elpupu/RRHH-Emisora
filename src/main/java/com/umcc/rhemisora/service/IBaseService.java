package com.umcc.rhemisora.service;

import java.util.List;

public interface IBaseService<T, Y> {
    public List<T> getAll();

    public T get(Y id);

    public boolean save(T element);

    public boolean add(T element);

    public boolean remove(Y id);
}
