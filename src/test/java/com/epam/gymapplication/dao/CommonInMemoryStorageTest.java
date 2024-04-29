package com.epam.gymapplication.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonInMemoryStorageTest {
    private CommonInMemoryStorage storage;
    @BeforeEach
    public void setUp() {
        storage = new CommonInMemoryStorage();
    }

    @Test
    public void saveAndGetById() {
        String id = "1";
        Object object = new Object();
        storage.save(id, object);
        assertEquals(object, storage.getById(id), "Object should be retrieved by ID after being saved");
    }



    @Test
    public void update() {
        String id = "1";
        Object object1 = new Object();
        Object object2 = new Object();
        storage.save(id, object1);
        storage.update(id, object2);
        assertEquals(object2, storage.getById(id), "Object should be updated to new value");
    }

    @Test
    void testDelete() {
        String id = "1";
        Object object = new Object();
        storage.save(id, object);
        storage.delete(id);
        assertNull(storage.getById(id), "Object should be null after being deleted");
    }
}