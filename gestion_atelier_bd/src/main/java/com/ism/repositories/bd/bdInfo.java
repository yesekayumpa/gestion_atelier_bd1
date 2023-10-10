package com.ism.repositories.bd;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class bdInfo {
    protected String dbUrl = "jdbc:mysql://localhost:3306/base_de_donnees";
    protected String dbUser = "votre_utilisateur";
    protected String dbPassword = "votre_mot_de_passe";

    // Méthode privée pour établir la connexion à la base de données
    public Connection connectToDatabase() throws ClassNotFoundException, SQLException {
        // Chargement du driver JDBC
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Établissement de la connexion
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }
}
