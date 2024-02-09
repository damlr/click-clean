package com.easycleanv4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestController {
	public TestController(String pseudo, String mdp) {

		boolean flag = false;
		DAOacces bdd = new DAOacces("easyclean_v2", "dam", "root");
		try {
			String strQuery = "SELECT userName,passWord FROM user WHERE userName = '" + pseudo + "' AND passWord = '"
					+ mdp + "';";
			ResultSet rsLogin = bdd.getStLogin().executeQuery(strQuery);

			while (rsLogin.next()) {
				System.out.println("Vous etes connecté en tant que " + pseudo);
				flag = true;
			}
		} catch (SQLException e) {
			System.err.println("Erreur");
			e.printStackTrace();
		}
		if (flag == false) {
			System.out.println("Erreur, retour a la page de connexion");
		}
	}
}
