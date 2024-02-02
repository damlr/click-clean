package com.click_and_clean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOacces {
	String strClassName;
	String dbName;
	String login;
	String password;
	String strUrl;
	Connection connection;

	public DAOacces(String dbName, String login, String password) {
		this.strClassName = "com.mysql.cj.jdbc.Driver";
		this.dbName = dbName;
		this.login = login;
		this.password = password;
		this.strUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false&serverTimezone=Europe/Paris";

		try {
			Class.forName(this.strClassName);
			Connection conn = DriverManager.getConnection(this.strUrl, this.login, this.password);
			this.connection = conn;
			System.out.println("Connection réussie");
			Statement stLogin = this.connection.createStatement();
		} catch (ClassNotFoundException e) {
			System.err.println("Driver non chargé !");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Erreur");
			e.printStackTrace();
		}
	}

	public String getStrClassName() {
		return strClassName;
	}

	public void setStrClassName(String strClassName) {
		this.strClassName = strClassName;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStrUrl() {
		return strUrl;
	}

	public void setStrUrl(String strUrl) {
		this.strUrl = strUrl;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void disconnect() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			System.err.println("Erreur");
			e.printStackTrace();
		}
	}

	public void lister() {
		try {
			String strQuery = "SELECT * FROM property;";
			Class.forName(strClassName);

			Statement stLogin = this.connection.createStatement();

			ResultSet rsLogin = stLogin.executeQuery(strQuery);

			while (rsLogin.next()) {
				System.out.println("ID[" + rsLogin.getInt(1) + "] prenom["
						+ rsLogin.getString(2) + "] Statut[" + rsLogin.getString(5));
			}
		} catch (ClassNotFoundException e) {
			System.err.println("Driver non chargé !");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Erreur");
			e.printStackTrace();
		}
	}

	public void addDAO(Property a) {
		try {
			String strQuery = "INSERT INTO property (numéro, rue, ville, département, région) VALUES (?, ?, ?, ?, ?)";
			try (PreparedStatement preparedStatement = this.connection.prepareStatement(strQuery)) {
				preparedStatement.setInt(1, a.getNumero());
				preparedStatement.setString(2, a.getRue());
				preparedStatement.setString(3, a.getVille());
				preparedStatement.setInt(4, a.getDepartement());
				preparedStatement.setString(5, a.getRegion());

				int rowsAffected = preparedStatement.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("Propriété ajoutée avec succès.");
				} else {
					System.out.println("Échec de l'ajout de la propriété.");
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur");
			e.printStackTrace();
		}

	}

	public void deleteDAO(Property a) {
		try {
			String strQuery = "DELETE FROM property WHERE id=" + a.getId() + ";";
			Class.forName(strClassName);

			Statement stLogin = this.connection.createStatement();

			stLogin.executeUpdate(strQuery);
		} catch (ClassNotFoundException e) {
			System.err.println("Driver non chargé !");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Erreur");
			e.printStackTrace();
		}
	}
}