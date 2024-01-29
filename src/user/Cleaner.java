package user;

public class Cleaner extends Utilisateur{
	int missionDone;
	int array;
	int salaryPerHour;
	int experience;
	
	public Cleaner(String username, String password, String profilePicture, String email, String description,
			String phoneNumber, String dateOfBirth, String dateOfCreation, int missionDone, int array,
			int salaryPerHour, int experience) {
		super(username, password, profilePicture, email, description, phoneNumber, dateOfBirth, dateOfCreation);
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

	public void setArray(int array) {
		this.array = array;
	}

	public int getSalaryPerHour() {
		return salaryPerHour;
	}

	public void setSalaryPerHour(int salaryPerHour) {
		this.salaryPerHour = salaryPerHour;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
}
