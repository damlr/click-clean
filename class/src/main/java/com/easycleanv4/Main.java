package com.easycleanv4;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        Utilisateur utilisateur = new Utilisateur(
                1, // iduser
                "nomUtilisateur", // username
                "Prenom", // firstName
                "Nom", // secondName
                30, // age
                "motDePasse123", // password
                "email@example.com", // email
                "0123456789", // phoneNumber
                "01/01/1990" // dateOfBirth
        );

        try {
            JSONObject coordonneesPropriete = GeocodingService.obtenirCoordonneesGPS(utilisateur.getId_user()); // Assurez-vous
                                                                                                                // que
                                                                                                                // cette
            // méthode retourne JSONObject
            JSONObject coordonneesCleaner = GeocodingService.obtenirCoordonneesCleanerGPS(utilisateur.getId_user()); // Idem

            if (coordonneesPropriete != null && coordonneesCleaner != null) {
                // Exemple de récupération de latitude et longitude
                double latPropriete = coordonneesPropriete.getDouble("lat");
                double lonPropriete = coordonneesPropriete.getDouble("lon");
                double latCleaner = coordonneesCleaner.getDouble("lat");
                double lonCleaner = coordonneesCleaner.getDouble("lon");

                // Calculer la distance
                double distance = geocodingService.calculerDistance(latPropriete, lonPropriete, latCleaner, lonCleaner);

                System.out.println("La distance entre la propriété et le cleaner est de : " + distance + " km");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// ControleurAddproperty controleur = new ControleurAddproperty("123 rue de
// Paris", 456, 100);

// controleur.ajouterPropriete();
// Créer un objet JSON
// JSONObject jsonObject = new JSONObject();
//
// // Ajouter des données à l'objet JSON
// jsonObject.put("ville", "Paris");
//
// // Convertir l'objet JSON en chaîne JSON
// String jsonString = jsonObject.toString();
//
// // Afficher la chaîne JSON résultante
// System.out.println(jsonString);
