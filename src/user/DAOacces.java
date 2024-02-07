package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOacces {
	private String strClassName;
	private String dbName;
	private String login;
	private String password;
	private String strUrl;
	private Connection connection;
	private Statement stLogin;
	
	
	public DAOacces(String dbName, String login, String password) {
		this.strClassName ="com.mysql.cj.jdbc.Driver";
		this.dbName = dbName;
		this.login = login;
		this.password = password;
		this.strUrl ="jdbc:mysql://localhost:3306/" +  dbName + "?useSSL=false&serverTimezone=Europe/Paris";
		
		try {
			Class.forName(this.strClassName);
			this.connection=DriverManager.getConnection(this.strUrl, this.login, this.password);
			System.out.println("Connection à la BDD "+dbName+" réussie");
			
			this.stLogin = this.connection.createStatement();
		}
		catch(ClassNotFoundException e) {  
			System.err.println("Driver non chargé !");  e.printStackTrace();
		} catch(SQLException e) {
			System.err.println("Erreur");  e.printStackTrace();
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
	
	public Statement getStLogin() {
		return stLogin;
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
		}
		catch(SQLException e) {
			System.err.println("Erreur");  e.printStackTrace();
		}
	}
	
	public void lister(){
		try {
			String strQuery= "SELECT * FROM users;";
		
			Statement stLogin = this.connection.createStatement();
			ResultSet rsLogin = stLogin.executeQuery(strQuery);
			
			while(rsLogin.next()) {
				System.out.println("ID["+ rsLogin.getInt(1) +"]\t username["
				+ rsLogin.getString(4) + "]\t Statut[" + rsLogin.getString(17)+"]");
			}
		} catch(SQLException e) {
			System.err.println("Erreur");  e.printStackTrace();
		}
	}
	
	public void deleteUser(String username) {
		try {
			String strQuery= "DELETE FROM users WHERE username='"+username+"';";
			Class.forName(strClassName);
		
			Statement stLogin = this.connection.createStatement();
			
			stLogin.executeUpdate(strQuery);
		}
		catch(ClassNotFoundException e) {  
			System.err.println("Driver non chargé !");  e.printStackTrace();
		} catch(SQLException e) {
			System.err.println("Erreur");  e.printStackTrace();
		}
	}
}

