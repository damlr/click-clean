package user;

/**
 * Classe administrateur
 * @author Simon
 */
public class Admin extends Utilisateur{

	public Admin(String username, String firstName, String secondName, int age, String password, String email,
			String description, String phoneNumber, String dateOfBirth, float globalGrade) {
		super(username, firstName, secondName, age, password, email, phoneNumber, dateOfBirth, globalGrade,description);
		// TODO Auto-generated constructor stub
	}
}
