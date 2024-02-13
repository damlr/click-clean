package com.easycleanv4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControleurAddproperty {
    private String address;
    private int codeEntrer;
    private int surface;
    private String dbName = "easyclean_v2";

    // Ajouter les paramètres au constructeur pour initialiser les variables
    // d'instance
    public ControleurAddproperty(String address, int codeEntrer, int surface) {
        this.address = address;
        this.codeEntrer = codeEntrer;
        this.surface = surface;
    }

    public void ajouterPropriete() {
        String strClassName = "com.mysql.cj.jdbc.Driver";
        String strUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false&serverTimezone=Europe/Paris";

        /** Utiliser try-with-resources pour une gestion automatique des ressources */
        try {
            // Charger le pilote de la base de données
            Class.forName(strClassName);

            // Établir une connexion à la base de données
            try (Connection conn = DriverManager.getConnection(strUrl, "dam", "root")) {

                // Préparer la requête SQL pour insérer les données
                String sql = "INSERT INTO propriete ( adress, code_entrer, surface) VALUES ( ?, ?, ?)";

                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    statement.setString(1, this.address);
                    statement.setInt(2, this.codeEntrer);
                    statement.setInt(3, this.surface);

                    // Exécuter la requête d'insertion
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Une nouvelle propriété a été ajoutée avec succès !");
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de pilote : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        }
    }
}
