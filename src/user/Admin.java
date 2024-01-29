package user;

public class Admin extends Utilisateur{

	public Admin(String username, String password, String profilePicture, String email, String description,
			String phoneNumber, String dateOfBirth, String dateOfCreation) {
		super(username, password, profilePicture, email, description, phoneNumber, dateOfBirth, dateOfCreation);
	}
}
