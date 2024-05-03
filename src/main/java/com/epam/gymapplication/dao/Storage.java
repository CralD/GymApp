package com.epam.gymapplication.dao;

public interface Storage <T> {
    T getById(Long id);
    void save(Long id, T t);
    void update(Long id, T t);
    void delete(Long id);

    boolean existByuserName(String username);
}
