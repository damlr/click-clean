package com.easycleanv4;

import java.sql.ResultSet;
import org.json.JSONObject;
import com.easycleanv4.GeocodingService;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class ControleurRechercheMission {
    private String dbName = "easyclean_v2"; // Supposition de nom de base de données
    private String login = "dam"; // Exemple d'utilisateur
    private String password = "root"; // Exemple de mot de passe
    private String strUrl;

    SortedMap<Double, Integer> ResultMission = new TreeMap<>();

    public ControleurRechercheMission(int idCleaner) {
        this.strUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false&serverTimezone=Europe/Paris";
        DAOacces dao = new DAOacces(dbName, login, password);
        try {
            String strQuery = "SELECT * FROM Mission WHERE statut = '1';";
            ResultSet rsLogin = dao.getStLogin().executeQuery(strQuery);
            while (rsLogin.next()) {
                int idMission = rsLogin.getInt("mission_id");
                int idPropriete = rsLogin.getInt("id_propriete");
                System.out.println("Mission ID: " + idMission + " id " + idPropriete);
                // Supposition que getAdresseCleaner et getAdressepropriete retournent des
                // adresses valides
                String adressCleaner = GeocodingService.getAdresseCleaner(idCleaner); // Utilisation de idMission comme
                String adressPropriete = GeocodingService.getAdressepropriete(idPropriete);

                System.out.println("adresse1: " + adressCleaner + " adresse2: " + adressPropriete);

                JSONObject coordonneesCleaner = GeocodingService.obtenirCoordonneesCleaner(adressCleaner);
                JSONObject coordonnesPropriete = GeocodingService.obtenirCoordonneesPropriete(adressPropriete);

                System.out.println("Lat long 1: " + coordonneesCleaner.getDouble("lat") + " " +
                        coordonneesCleaner.getDouble("lon") + "Lat long 2: " + coordonnesPropriete.getDouble("lat")
                        + " " +
                        coordonnesPropriete.getDouble("lon"));

                double distance = GeocodingService.calculerDistance(coordonneesCleaner.getDouble("lat"),
                        coordonneesCleaner.getDouble("lon"), coordonnesPropriete.getDouble("lat"),
                        coordonnesPropriete.getDouble("lon"));

                System.out.println("Distance: " + distance);

                ResultMission.put(distance, idMission);
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erreur: " + e.getMessage());
        }
        for (double key : ResultMission.keySet()) {
            System.out.println(key + "/" + ResultMission.get(key));
        }

    }
}
