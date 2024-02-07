package user;

import java.sql.SQLException;
import java.sql.Statement;

public class ControllerCreateAccount {
	public ControllerCreateAccount(boolean isCleaner, String firstName, String secondName,String username,String email,String password,int age,
			String description, String phoneNumber, String dateOfBirth,float globalGrade,int missionDone, int perimeter,int tarif) {
		
		if(isCleaner) {
			Cleaner user=new Cleaner(firstName,secondName,username,email,password,age,description,phoneNumber,dateOfBirth,globalGrade,missionDone,perimeter,tarif);
			DAOacces bdd = new DAOacces("easy_clean","root","");
			try {
				String strQuery= "INSERT INTO users (first_name,second_name,username,mail,password,age,bio,phone_nulber,date_of_birth,note,nb_mission,perimeter,tarif_horaire,role) VALUES('"+user.getFirstName()+"','"+user.getSecondName()+"','"+user.getUsername()+"','"+user.getEmail()+"','"+user.getPassword()+"',"+user.getAge()+",'"+user.getDescription()+"',"+user.getPhoneNumber()+",'"+user.getDateOfBirth()+"',"+user.getGlobalGrade()+","+user.getMissionDone()+","+user.getPerimeter()+","+user.getSalaryPerHour()+",'"+user.getStatut()+"');";
				
				Statement stLogin = bdd.getConnection().createStatement();	
				stLogin.executeUpdate(strQuery);
			}
			catch(SQLException e) {
				System.err.println("Erreur");  e.printStackTrace();
			}
			bdd.disconnect();
		}
		else {
			Proprietaire user= new Proprietaire(firstName,secondName,username,email,password,age,description,phoneNumber,dateOfBirth,globalGrade);
			DAOacces bdd = new DAOacces("easy_clean","root","");
			try {
				String strQuery= "INSERT INTO users (first_name,second_name,username,mail,password,age,bio,phone_nulber,date_of_birth,note,role) VALUES('"+user.getFirstName()+"','"+user.getSecondName()+"','"+user.getUsername()+"','"+user.getEmail()+"','"+user.getPassword()+"',"+user.getAge()+",'"+user.getDescription()+"',"+user.getPhoneNumber()+",'"+user.getDateOfBirth()+"','"+user.getGlobalGrade()+"','"+user.getStatut()+"');";
				
				Statement stLogin = bdd.getConnection().createStatement();	
				stLogin.executeUpdate(strQuery);
			}
			catch(SQLException e) {
				System.err.println("Erreur");  e.printStackTrace();
			}
			bdd.disconnect();
		}
	}
}
