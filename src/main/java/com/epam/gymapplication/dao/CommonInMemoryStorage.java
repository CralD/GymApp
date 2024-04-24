package com.epam.gymapplication.dao;

import java.util.HashMap;
import java.util.Map;

public class CommonInMemoryStorage implements Storage{


    private Map<String, Object> storage= new HashMap<>();


    @Override
    public Object getById(String id) {
        return storage.get(id);
    }
    @Override
    public void save(String id,Object object){
        storage.put(id,object);
    }
    @Override
    public void update(String id,Object object){
        storage.put(id,object);
    }

    @Override
    public void delete(String id){
        storage.remove(id);
    }

}
