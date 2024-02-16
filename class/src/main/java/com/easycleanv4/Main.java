package com.easycleanv4;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        Utilisateur utilisateur = new Utilisateur(
                5, // iduser
                "nomUtilisateur", // username
                "Prenom", // firstName
                "Nom", // secondName
                30, // age
                "motDePasse123", // password
                "email@example.com", // email
                "0123456789", // phoneNumber
                "01/01/1990" // dateOfBirth
        );
        ControleurRechercheMission controleurRechercheMission = new ControleurRechercheMission(
                utilisateur.getId_user());

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
