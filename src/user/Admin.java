package user;

import java.util.HashMap;

/**
 * Classe administrateur
 * @author Simon
 */
public class Admin extends Utilisateur{

	public Admin(String username, String firstName, String secondName, int age, String password, String profilePicture,
			String email, String description, String phoneNumber, String dateOfBirth, String dateOfCreation,
			HashMap<Float, String> comment, float globalGrade) {
		super(username, firstName, secondName, age, password, profilePicture, email, description, phoneNumber, dateOfBirth,
				dateOfCreation, comment, globalGrade);
		// TODO Auto-generated constructor stub
	}
}
