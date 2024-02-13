package user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestController {
	public TestController(String pseudo,String mdp) {
		
		boolean flag = false;
		DAOacces bdd = new DAOacces("click_n_clean","root","");
		try {
			String strQuery= "SELECT userName,passWord FROM user WHERE userName = '"+pseudo+"' AND passWord = '"+mdp+"';";
			ResultSet rsLogin = bdd.getStLogin().executeQuery(strQuery);
			
			while(rsLogin.next()) {
				System.out.println("Vous etes connecté en tant que "+pseudo);
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
