package user;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerConnexion {
	public ControllerConnexion(String pseudo,String mdp) {
		
		boolean flag = false;
		DAOacces bdd = new DAOacces("easy_clean","root","");
		try {
			String strQuery= "SELECT * FROM users WHERE username = '"+pseudo+"' AND password = '"+mdp+"';";
			ResultSet rsLogin = bdd.getStLogin().executeQuery(strQuery);
			
			while(rsLogin.next()) {
				
				if(rsLogin.getString("role").equals("Cleaner")) {
					Cleaner user = new Cleaner(rsLogin.getString("first_name"),rsLogin.getString("second_name"),rsLogin.getString("username"),rsLogin.getString("mail"),rsLogin.getString("password"),rsLogin.getInt("age"),rsLogin.getString("bio"),rsLogin.getString("phone_nulber"),rsLogin.getString("date_of_birth"),rsLogin.getFloat("note"),rsLogin.getInt("nb_mission"),rsLogin.getInt("perimeter"),rsLogin.getInt("tarif_horaire"));
					user.setDateOfCreation(rsLogin.getDate("date_creation"));
					System.out.println(user.toString());
				}
				else if(rsLogin.getString("role").equals("Proprietaire")) {
					Proprietaire user = new Proprietaire(rsLogin.getString("first_name"), rsLogin.getString("second_name"),rsLogin.getString("username"),rsLogin.getString("mail"), rsLogin.getString("password"),rsLogin.getInt("age"),  rsLogin.getString("bio"), rsLogin.getString("phone_nulber"),rsLogin.getString("dateOfBirth"),rsLogin.getFloat("note"));
					user.setDateOfCreation(rsLogin.getDate("date_creation"));
					System.out.println(user.toString());
				}
				flag = true;
			}
		}
		catch(SQLException e) {
			System.err.println("Erreur");  e.printStackTrace();
		}
		if(flag == false) {
			System.out.println("Erreur, retour a la page de connexion");
		}	
	}
}
