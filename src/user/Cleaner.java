package user;

import java.util.HashMap;

/**
 * Classe de prestataire
 * @author Simon
 */
public class Cleaner extends Utilisateur{
	int missionDone;
	int array;
	int salaryPerHour;
	int experience;

	public Cleaner(String username, String firstName, String secondName, int age, String password,
			String profilePicture, String email, String description, String phoneNumber, String dateOfBirth,
			String dateOfCreation, HashMap<Float, String> comment, float globalGrade, int missionDone, int array,
			int salaryPerHour, int experience) {
		super(username, firstName, secondName, age, password, profilePicture, email, description, phoneNumber,
				dateOfBirth, dateOfCreation, comment, globalGrade);
		this.missionDone = missionDone;
		this.array = array;
		this.salaryPerHour = salaryPerHour;
		this.experience = experience;
	}

	public int getMissionDone() {
		return missionDone;
	}

	public void setMissionDone(int missionDone) {
		this.missionDone = missionDone;
	}

	public int getArray() {
		return array;
	}
	/**
	 * Rayon en kilometre autour du domicile du prestataire definissant la zone d'action du cleaner
	 * @param array
	 */
	public void setArray(int array) {
		this.array = array;
	}
	
	public int getSalaryPerHour() {
		return salaryPerHour;
	}
	/**
	 * Salaire horraire définit par le préstataire
	 * @param salaryPerHour
	 */
	public void setSalaryPerHour(int salaryPerHour) {
		this.salaryPerHour = salaryPerHour;
	}
	/**
	 * Nombre de mission deja effectue par le cleaner
	 * @return
	 */
	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
}
