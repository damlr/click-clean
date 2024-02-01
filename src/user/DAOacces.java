package user;

import java.sql.Connection;
import java.sql.DriverManager;
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
		this.strClassName ="com.mysql.cj.jdbc.Driver";
		this.dbName = dbName;
		this.login = login;
		this.password = password;
		this.strUrl ="jdbc:mysql://localhost:3306/" +  dbName + "?useSSL=false&serverTimezone=Europe/Paris";
		
		try {
			Class.forName(this.strClassName);
			Connection conn = DriverManager.getConnection(this.strUrl, this.login, this.password);
			this.connection=conn;
			System.out.println("Connection à la BDD "+dbName+" réussie");
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
			String strQuery= "SELECT * FROM user;";
		
			Statement stLogin = this.connection.createStatement();
			ResultSet rsLogin = stLogin.executeQuery(strQuery);
			
			while(rsLogin.next()) {
				System.out.println("ID["+ rsLogin.getInt(1) +"]\t username["
				+ rsLogin.getString(4) + "]\t Statut[" + rsLogin.getString(14)+"]");
			}
		} catch(SQLException e) {
			System.err.println("Erreur");  e.printStackTrace();
		}
	}
	
	public void addCleaner(Cleaner a) {
		try {
			String strQuery= "INSERT INTO user (firstName,secondName,userName,email,passWord,age,phoneNumber,dateOfBirth,statut) VALUES('"+a.getFirstName()+"','"+a.getSecondName()+"','"+a.getUsername()+"','"+a.getEmail()+"','"+a.getPassword()+"',"+a.getAge()+","+a.getPhoneNumber()+",'"+a.getDateOfBirth()+"','"+a.getStatut()+"');";
			
			Statement stLogin = this.connection.createStatement();	
			int rsLogin = stLogin.executeUpdate(strQuery);
		}
		catch(SQLException e) {
			System.err.println("Erreur");  e.printStackTrace();
		}
	}
	
	public void addProprietaire(Proprietaire a) {
		try {
			String strQuery= "INSERT INTO user (firstName,secondName,userName,email,passWord,age,phoneNumber,dateOfBirth,statut) VALUES('"+a.getFirstName()+"','"+a.getSecondName()+"','"+a.getUsername()+"','"+a.getEmail()+"','"+a.getPassword()+"',"+a.getAge()+","+a.getPhoneNumber()+",'"+a.getDateOfBirth()+"','"+a.getStatut()+"');";
			
			Statement stLogin = this.connection.createStatement();	
			int rsLogin = stLogin.executeUpdate(strQuery);
		}
		catch(SQLException e) {
			System.err.println("Erreur");  e.printStackTrace();
		}
	}
	
	public void deleteCleaner(Cleaner a) {
		try {
			String strQuery= "DELETE FROM user WHERE userName='"+a.getUsername()+"';";
			Class.forName(strClassName);
		
			Statement stLogin = this.connection.createStatement();
			
			int rsLogin = stLogin.executeUpdate(strQuery);
		}
		catch(ClassNotFoundException e) {  
			System.err.println("Driver non chargé !");  e.printStackTrace();
		} catch(SQLException e) {
			System.err.println("Erreur");  e.printStackTrace();
		}
	}
	
	public void deleteProprietaire(Proprietaire a) {
		try {
			String strQuery= "DELETE FROM user WHERE userName='"+a.getUsername()+"';";
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
	
	public boolean connection(String username,String mdp) {
		try {
			String strQuery= "SELECT userName,passWord FROM user WHERE userName = '"+username+"' AND passWord = '"+mdp+"';";
		
			Statement stLogin = this.connection.createStatement();
			ResultSet rsLogin = stLogin.executeQuery(strQuery);
			
			while(rsLogin.next()) {
				return true;
			}
		}
		catch(SQLException e) {
			System.err.println("Erreur");  e.printStackTrace();
		}
		return false;
	}
}

