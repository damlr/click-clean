package com.easycleanv4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import com.easycleanv4.GeocodingService;

public class ControleurRechercheMission {
    private String strClassName;
    private String dbName;
    private String login;
    private String password;
    private String strUrl;

    HashMap<Integer, Integer> ResultMission = new HashMap<Integer, Integer>();

    public ControleurRechercheMission() {

        this.strClassName = "com.mysql.cj.jdbc.Driver";
        this.strUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false&serverTimezone=Europe/Paris";

        boolean flag = false;
        DAOacces dao = new DAOacces("easyclean_v2", "dam", "root");

        try {
            String strQuery = "SELECT * FROM Mission WHERE statut = '1';";
            ResultSet rsLogin = dao.getStLogin().executeQuery(strQuery);

            while (rsLogin.next()) {
                String idMission = rsLogin.getString("mission_id");
                System.out.println("Mission ID: " + idMission);

            }
            flag = true;
        } catch (SQLException e) {
            System.err.println("Erreur");
            e.printStackTrace();
        }

        if (!flag) {
            System.out.println("Erreur, retour à la page de connexion");
        }
        dao.disconnect();
    }

}
