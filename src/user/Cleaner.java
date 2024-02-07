package user;

/**
 * Classe de prestataire
 * @author Simon
 */
public class Cleaner extends Utilisateur{
	private int missionDone;
	private int salaryPerHour;
	private String statut;
	private int perimeter;
	
	public Cleaner(String firstName, String secondName,String username,String email,String password,
			int age,String description,String phoneNumber, String dateOfBirth, float globalGrade, int missionDone,
			int perimeter,int salaryPerHour) {
		super(username, firstName, secondName, age, password, email, phoneNumber, dateOfBirth, globalGrade,description);
		this.statut="Cleaner";
		this.missionDone = missionDone;
		this.salaryPerHour = salaryPerHour;
		this.perimeter = perimeter;
	}
	
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}

	public int getMissionDone() {
		return missionDone;
	}

	public void setMissionDone(int missionDone) {
		this.missionDone = missionDone;
	}

	public int getPerimeter() {
		return this.perimeter;
	}
	/**
	 * Rayon en kilometre autour du domicile du prestataire definissant la zone d'action du cleaner
	 * @param array
	 */
	public void setPerimeter(int perimeter) {
		this.perimeter = perimeter;
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
}
