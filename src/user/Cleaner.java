package user;

import java.util.HashMap;

/**
 * Classe de prestataire
 * @author Simon
 */
public class Cleaner extends Utilisateur{
	private int missionDone;
	private int array;
	private int salaryPerHour;
	private int experience;
	private HashMap<String, String>hours;
	
	public Cleaner(String username, String firstName, String secondName, int age, String password, String email,
			String description, String phoneNumber, String dateOfBirth) {
		super(username, firstName, secondName, age, password, email, description, phoneNumber, dateOfBirth);
	}
	public HashMap<String, String> getHours() {
		return hours;
	}
	/**
	 * Hashmap du planning des jours de la semaine
	 * @param a Jours au format suivant: MON, TUE, WED, THU, FRI, SAT, SUN
	 * @param b Plage horraire en format 24h associé au jour par exemple 8-13, 14-18
	 */
	public void setHours(String a, String b) {
		this.hours.put(a,b);
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
