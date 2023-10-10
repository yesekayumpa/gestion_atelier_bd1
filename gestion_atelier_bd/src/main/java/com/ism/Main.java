package com.ism;

import java.util.Scanner;

import com.ism.entities.Categorie;
import com.ism.repositories.ITable;
import com.ism.repositories.list.TableCategorie;
import com.ism.services.CategorieServiceImpl;

public class Main {
    public static void main(String[] args) throws Exception {
        ITable<Categorie> repository = new TableCategorie();
        CategorieServiceImpl categorieServiceImpl = new CategorieServiceImpl(repository);
        int choix;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1-Ajouter Categorie");
            System.out.println("2-Lister Categorie");
            System.out.println("3-Quitter");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    System.out.println("Entrer le libelle");
                    Categorie categorie = new Categorie(scanner.nextLine());
                    categorieServiceImpl.add(categorie);
                    break;
                case 2:
                    categorieServiceImpl.getAll().forEach(System.out::println);
                    break;
            }
        } while (choix != 3);
    }
}