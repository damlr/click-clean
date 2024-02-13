package com.easycleanv4;

import java.util.HashMap;

/**
 * Class mere utilisateur regroupant touts les attributs et methodes communes
 * aux trois types d'utilisateurs.
 * 
 * @author Simon
 */
public class Utilisateur {

	private String username;
	private int id_user;
	private String firstName;
	private String secondName;
	private int age;
	private String password;
	private String profilePicture;
	private String email;
	private String description;
	private String phoneNumber;
	private String dateOfBirth;
	private String dateOfCreation;
	private HashMap<Float, String> comment;
	float globalGrade;

	public Utilisateur(int id_user, String username, String firstName, String secondName, int age, String password,
			String email, String phoneNumber, String dateOfBirth) {
		super();
		this.id_user = id_user;
		this.username = username;
		this.firstName = firstName;
		this.secondName = secondName;
		this.age = age;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.comment = new HashMap<Float, String>();
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public float getGlobalGrade() {
		return globalGrade;
	}

	public void setGlobalGrade(float globalGrade) {
		this.globalGrade = globalGrade;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	/**
	 * String indiquant le nom de l'image pour aller la chercher dans la bdd
	 * 
	 * @return
	 */
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Date au format jour/mois/annee
	 * 
	 * @return
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(String dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public HashMap<Float, String> getComment() {
		return comment;
	}

	/**
	 * Hashmap regroupant les commentaires attribue a l'utilisateur avec la note en
	 * float et le commentaire en String
	 * 
	 * @param a Note en decimal
	 * @param b Commentaire
	 */
	public void setComment(float a, String b) {
		this.comment.put(a, b);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Utilisateur [username=" + username + ", password=" + password + ", profilePicture=" + profilePicture
				+ ", email=" + email + ", description=" + description + ", phoneNumber=" + phoneNumber
				+ ", dateOfBirth=" + dateOfBirth + ", dateOfCreation=" + dateOfCreation + ", getUsername()="
				+ getUsername() + ", getPassword()=" + getPassword() + ", getProfilePicture()=" + getProfilePicture()
				+ ", getEmail()=" + getEmail() + ", getDescription()=" + getDescription() + ", getPhoneNumber()="
				+ getPhoneNumber() + ", getDateOfBirth()=" + getDateOfBirth() + ", getDateOfCreation()="
				+ getDateOfCreation() + "]";
	}

	public void comment(Utilisateur a, float note, String comment) {
		a.setComment(note, comment);
	}

	public void printComment() {
		System.out.println(this.comment);
	}
}
