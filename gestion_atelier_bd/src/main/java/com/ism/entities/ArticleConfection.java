package com.ism.entities;

import java.util.ArrayList;

public class ArticleConfection extends AbstractEntitie {
    // private int id;
    // private String libelle;
    private double prix;
    private double qte;

    // att navi
    // manyToOne
    Categorie categorie;

    // mayToMany
    // couplage fort
    ArrayList<Unite> unites = new ArrayList<>();

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void addUnite(Unite unite) {
        unites.add(unite);
    }

    public ArrayList<Unite> getUnites() {
        return unites;
    }

    public ArticleConfection(int id, String libelle, double prix, double qte) {
        // this.id = id;
        // this.libelle = libelle;
        this.prix = prix;
        this.qte = qte;
    }

    public ArticleConfection() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getQte() {
        return qte;
    }

    public void setQte(double qte) {
        this.qte = qte;
    }

    @Override
    public String toString() {
        return "ArticleConfection [prix=" + prix + ", qte=" + qte + ", categorie=" + categorie + ", unites=" + unites
                + "]";
    }

}
