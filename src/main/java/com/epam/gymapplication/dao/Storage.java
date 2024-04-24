package com.epam.gymapplication.dao;

public interface Storage {
    Object getById(String id);
    void save(String id, Object object);
    void update(String id, Object object);
    void delete(String id);
}
