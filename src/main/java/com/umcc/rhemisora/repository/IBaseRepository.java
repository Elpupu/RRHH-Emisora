package com.umcc.rhemisora.repository;

import java.util.List;

public interface IBaseRepository<T, Y> {
    public boolean save(T element);
    public boolean update(T element);
    public List<T> findAll();
    public T findById(Y id);
    public boolean delete(T element);
}
