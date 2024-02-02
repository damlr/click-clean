package com.click_and_clean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tools {
    /** attributs */
    private int nb_cleaners;
    private int nb_owners;
    private int nb_mission_area;

    public Tools(int nb_cleaners, int nb_owners, int nb_mission_area) {
        this.nb_cleaners = nb_cleaners;
        this.nb_owners = nb_owners;
        this.nb_mission_area = nb_mission_area;
    }

    public int getNb_cleaners() {
        return nb_cleaners;
    }

    public void setNb_cleaners(int nb_cleaners) {
        this.nb_cleaners = nb_cleaners;
    }

    public int getNb_owners() {
        return nb_owners;
    }

    public void setNb_owners(int nb_owners) {
        this.nb_owners = nb_owners;
    }

    public int getNb_mission_area() {
        return nb_mission_area;
    }

    public void setNb_mission_area(int nb_mission_area) {
        this.nb_mission_area = nb_mission_area;
    }

    /** method pour calculer les nombres de mission sur le site */
    public void countMissions() {
        // Créer une connexion à la base de données
        try (Connection connection = DriverManager.getConnection("url_de_connexion", "root",
                "")) {
            // Préparer la requête SQL
            String sql = "SELECT COUNT(*) AS nombre_missions FROM mission WHERE statut = 'available'";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Exécuter la requête
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int nombreMissions = resultSet.getInt("nombre_missions");
                        System.out.println("Nombre de missions disponibles : " + nombreMissions);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** method de cacul de mission disponible par rapport à la zone */
    public void countMissionsInArea() {

    }

}
