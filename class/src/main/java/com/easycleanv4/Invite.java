package com.easycleanv4;

public class Invite {
	public void newAccount(boolean isCleaner, String username, String firstName, String secondName, int age,
			String password, String email,
			String description, String phoneNumber, String dateOfBirth) {
		if (isCleaner) {
			Cleaner cleaner = new Cleaner(username, firstName, secondName, age, password, email, description,
					phoneNumber, dateOfBirth);
			DAOacces bdd = new DAOacces("click_n_clean", "root", "");
			bdd.addCleaner(cleaner);
			bdd.disconnect();
		} else {
			Proprietaire proprietaire = new Proprietaire(username, firstName, secondName, age, password, email,
					description, phoneNumber, dateOfBirth);
			DAOacces bdd = new DAOacces("click_n_clean", "root", "");
			bdd.addProprietaire(proprietaire);
			bdd.disconnect();
		}
	}
}
