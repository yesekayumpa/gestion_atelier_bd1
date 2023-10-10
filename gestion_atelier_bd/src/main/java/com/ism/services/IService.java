package com.ism.services;

import java.util.ArrayList;

import com.ism.entities.Categorie;

public interface IService<A> {
    int add(Categorie categorie);

    ArrayList<Categorie> getAll();

    int update(Categorie categorie);

    Categorie show(int id);

    int remove(int id);

    int[] remove(int[] ids);
}
