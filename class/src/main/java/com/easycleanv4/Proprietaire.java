package com.easycleanv4;

import java.util.ArrayList;

/**
 * Classe de demandeur de menage, implementer un vector de Propriete quand la
 * classe sera faites
 * 
 * @author Simon
 */
public class Proprietaire extends Utilisateur {

	ArrayList<Property> properties;
	String statut;

	public Proprietaire(String username, String firstName, String secondName, int age, String password, String email,
			String description, String phoneNumber, String dateOfBirth) {
		super(username, firstName, secondName, age, password, email, phoneNumber, dateOfBirth);
		this.statut = "Proprietaire";
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Property> getProperties() {
		return properties;
	}

	/**
	 * Tableau regroupant les proprietes du proprietaire
	 * 
	 * @param properties
	 */
	public void setProperties(Property properties) {
		this.properties.add(properties);
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

}
