package com.ism.services;

import java.util.ArrayList;

import com.ism.entities.Categorie;
import com.ism.repositories.ITable;
// import com.ism.repositories.list.TableCategorie;

public class CategorieServiceImpl implements CategorieService {

    // Couplage faible
    private ITable<Categorie> categoriesRepository;

    // injection de dependance via le constructor
    public CategorieServiceImpl(ITable<Categorie> categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    // injection de dependance via le setter
    public void setcategoriesRepository(ITable<Categorie> categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public int add(Categorie categorie) {
        return categoriesRepository.insert(categorie);
    }

    @Override
    public ArrayList<Categorie> getAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public int update(Categorie categorie) {
        return categoriesRepository.update(categorie);
    }

    @Override
    public Categorie show(int id) {
        return categoriesRepository.findById(id);
    }

    @Override
    public int remove(int id) {
        return categoriesRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        int[] idsNotDelete = new int[ids.length];
        int nbre = 0;
        for (int id = 0; id < ids.length; id++) {
            if (categoriesRepository.delete(id) == 0) {
                idsNotDelete[nbre++] = id;
            }
        }
        return idsNotDelete;
    }

}
