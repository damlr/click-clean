package user;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe de demandeur de menage, implementer un vector de Propriete quand la classe sera faites
 * @author Simon
 */
public class Proprietaire extends Utilisateur{

	ArrayList<Property> properties;

	public Proprietaire(String username, String firstName, String secondName, int age, String password,
			String profilePicture, String email, String description, String phoneNumber, String dateOfBirth,
			String dateOfCreation, HashMap<Float, String> comment, float globalGrade, ArrayList<Property> properties) {
		super(username, firstName, secondName, age, password, profilePicture, email, description, phoneNumber,
				dateOfBirth, dateOfCreation, comment, globalGrade);
		this.properties = new ArrayList<Property>();
	}

	public ArrayList<Property> getProperties() {
		return properties;
	}

	public void setProperties(Property properties) {
		this.properties.add(properties);
	}
}
