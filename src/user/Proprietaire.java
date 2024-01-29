package user;

import java.util.HashMap;

/**
 * Classe de demandeur de menage, implementer un vector de Propriete quand la classe sera faites
 * @author Simon
 */
public class Proprietaire extends Utilisateur{

	public Proprietaire(String username, String firstName, String secondName, int age, String password,
			String profilePicture, String email, String description, String phoneNumber, String dateOfBirth,
			String dateOfCreation, HashMap<Float, String> comment, float globalGrade) {
		super(username, firstName, secondName, age, password, profilePicture, email, description, phoneNumber, dateOfBirth,
				dateOfCreation, comment, globalGrade);
		// TODO Auto-generated constructor stub
	}
}
