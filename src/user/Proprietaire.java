package user;
import java.util.HashMap;

public class Proprietaire extends Utilisateur{
	float globalGrade;
	HashMap<Float, String> comment;
	
	public Proprietaire(String username, String password, String profilePicture, String email, String description,
			String phoneNumber, String dateOfBirth, String dateOfCreation, float globalGrade,
			HashMap<Float, String> comment) {
		super(username, password, profilePicture, email, description, phoneNumber, dateOfBirth, dateOfCreation);
		this.globalGrade = globalGrade;
		this.comment = comment;
	}

	public float getGlobalGrade() {
		return globalGrade;
	}

	public void setGlobalGrade(float globalGrade) {
		this.globalGrade = globalGrade;
	}

	public HashMap<Float, String> getComment() {
		return comment;
	}

	public void setComment(HashMap<Float, String> comment) {
		this.comment = comment;
	}
}
