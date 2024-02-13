package com.easycleanv4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class GeocodingService {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/easyclean_v2?serverTimezone=UTC";
    private static final String USER = "dam";
    private static final String PASS = "root";

    public allGeocodingService(int id_user, int idPropriete) {

        public JSONObject obtenirCoordonneesGPS(idPropriete) throws Exception {
            // Récupérer l'adresse complète de la base de données
            String completeAddress = getAdresseFromDB(idPropriete);

            if (completeAddress != null && !completeAddress.isEmpty()) {
                String url = "https://nominatim.openstreetmap.org/search?q=" + completeAddress.replace(" ", "+")
                        + "&format=json&limit=1";

                URL apiUrl = new URL(url);
                HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
                conn.setRequestMethod("GET");
                conn.addRequestProperty("User-Agent", "Mozilla/5.0");

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Convertir la réponse en chaîne JSON
                String jsonResponse = response.toString();
                System.out.println(jsonResponse);

                // Analyser la réponse JSON et extraire les coordonnées GPS
                JSONArray jsonArray = new JSONArray(jsonResponse);
                if (jsonArray.length() > 0) {
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    double lat = jsonObject.getDouble("lat");
                    double lon = jsonObject.getDouble("lon");
                    System.out.println("Latitude: " + lat + ", Longitude: " + lon);
                    return jsonObject;
                } else {
                    System.out.println("Aucune coordonnée GPS trouvée pour l'adresse.");
                }
            } else {
                System.out.println("Aucune adresse complète trouvée dans la base de données.");
            }
            return null;
        }

        private static String getAdresseFromDB(int idPropriete) {
            String completeAddressProprietaire = null;
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
                String sql = "SELECT adress, ville, code_postal FROM propriete WHERE propriete_id  = " + idPropriete;
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        String address = resultSet.getString("adress");
                        String city = resultSet.getString("ville");
                        String postalCode = resultSet.getString("code_postal");
                        completeAddressProprietaire = address + ", " + city + ", " + postalCode;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return completeAddressProprietaire;
        }

        public JSONObject obtenirCoordonneesCleanerGPS(int idCleaner) throws Exception {
            // Récupérer l'adresse complète de la base de données
            String completeAddress = getAdresseCleaner(idCleaner);

            if (completeAddress != null && !completeAddress.isEmpty()) {
                String url = "https://nominatim.openstreetmap.org/search?q=" + completeAddress.replace(" ", "+")
                        + "&format=json&limit=1";

                URL apiUrl = new URL(url);
                HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
                conn.setRequestMethod("GET");
                conn.addRequestProperty("User-Agent", "Mozilla/5.0");

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Convertir la réponse en chaîne JSON
                String jsonResponse = response.toString();
                System.out.println(jsonResponse);

                // Analyser la réponse JSON et extraire les coordonnées GPS
                JSONArray jsonArray = new JSONArray(jsonResponse);
                if (jsonArray.length() > 0) {
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    double lat = jsonObject.getDouble("lat");
                    double lon = jsonObject.getDouble("lon");
                    System.out.println("Latitude: " + lat + ", Longitude: " + lon);
                    return jsonObject;
                } else {
                    System.out.println("Aucune coordonnée GPS trouvée pour l'adresse.");
                }
            } else {
                System.out.println("Aucune adresse complète trouvée dans la base de données.");
            }
            return null;
        }

        private static String getAdresseCleaner(int idCleaner) {
            String adresseCleaner = null;
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
                String sql = "SELECT adresse, ville, code_postal FROM users WHERE id_user = " + idCleaner;
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        String address = resultSet.getString("adresse");
                        String city = resultSet.getString("ville");
                        String postalCode = resultSet.getString("code_postal");
                        adresseCleaner = address + ", " + city + ", " + postalCode;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return adresseCleaner;
        }
    }

    public double calculerDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Rayon de la Terre en kilomètres
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                        * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c; // convertir en kilomètres

        return distance;
    }

    // private static String calculdistance() {
    // private int longueur;
    //
    // }
}
