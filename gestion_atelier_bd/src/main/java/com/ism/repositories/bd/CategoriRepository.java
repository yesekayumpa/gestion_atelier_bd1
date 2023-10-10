package com.ism.repositories.bd;

import java.util.ArrayList;

import com.ism.entities.AbstractEntitie;
import com.ism.entities.Categorie;
import com.ism.repositories.ITable;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriRepository extends bdInfo implements ITable<Categorie> {

    @Override
    public ArrayList<Categorie> findAll() {
        ArrayList<Categorie> categories = new ArrayList<>();
        try (Connection conn = connectToDatabase();
                Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT id, libelle FROM table");
            while (rs.next()) {
                Categorie categorie = new Categorie(rs.getInt("id"), rs.getString("libelle"));
                categories.add(categorie);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Categorie findById(int id) {
        Categorie categorie = null;
        try (Connection conn = connectToDatabase();
                PreparedStatement statement = conn
                        .prepareStatement("SELECT id, libelle FROM table WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                categorie = new Categorie(rs.getInt("id"), rs.getString("libelle"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return categorie;
    }

    @Override
    public int insert(Categorie data) {
        int nbrLignes = 0;
        try (Connection conn = connectToDatabase();
                PreparedStatement statement = conn.prepareStatement("INSERT INTO votre_table (libelle) VALUES (?)")) {
            statement.setString(1, data.getLibelle());
            nbrLignes = statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return nbrLignes;
    }

    @Override
    public int update(Categorie data) {
        int nbrLignes = 0;
        try (Connection conn = connectToDatabase();
                PreparedStatement statement = conn
                        .prepareStatement("UPDATE votre_table SET libelle = ? WHERE id = ?")) {
            statement.setString(1, data.getLibelle());
            statement.setInt(2, data.getId());
            nbrLignes = statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return nbrLignes;
    }

    @Override
    public int delete(int id) {
        int nbrLignes = 0;
        try (Connection conn = connectToDatabase();
                PreparedStatement statement = conn.prepareStatement("DELETE FROM votre_table WHERE id = ?")) {
            statement.setInt(1, id);
            nbrLignes = statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return nbrLignes;
    }

    @Override
    public int indexOf(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

}
