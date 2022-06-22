package com.example.bilabonnement.repository;

import com.example.bilabonnement.models.Bil;

import java.util.List;

public interface IRepository <T>{ // CRUD implementation in Repo beacuse of Separation of Concerns

    //Create
    void create(T entity);

    //ReadAll
    List<T> readAll();

    //Update
    void update(int id);

    //Delete // hvordan gør man med ( T entity)
    void delete(int id);
}
