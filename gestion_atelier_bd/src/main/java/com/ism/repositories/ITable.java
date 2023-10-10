package com.ism.repositories;

import java.util.ArrayList;

import com.ism.entities.AbstractEntitie;

public interface ITable<T extends AbstractEntitie> {
    int insert(T data);

    int update(T data);

    ArrayList<T> findAll();

    T findById(int id);

    int indexOf(int id);

    int delete(int id);

}
