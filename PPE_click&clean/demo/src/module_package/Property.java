package com.click_and_clean;

public class Property {
    /** mise en place des attribut */
    private int numéro;
    private String rue;
    private String ville;
    private int departement;
    private String région;
    private int id;

    public Property(int numéro, String rue, String ville, int departement, String région) {
        this.numéro = numéro;
        this.rue = rue;
        this.ville = ville;
        this.departement = departement;
        this.région = région;
    }

    // Getters
    public int getNumero() {
        return numéro;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public int getDepartement() {
        return departement;
    }

    public String getRegion() {
        return région;
    }

    public int getId() {
        return id;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNumero(int numéro) {
        this.numéro = numéro;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setDepartement(int departement) {
        this.departement = departement;
    }

    public void setRegion(String région) {
        this.région = région;
    }

    public void addProperty(int numéro, String rue, String ville, int departement, String région) {
        Property property = new Property(numéro, rue, ville, departement, région);

    }

    public void setProperty(int numéro, String rue, String ville, int departement, String région) {
        Property property = new Property(numéro, rue, ville, departement, région);
    }

    public void delProperty(int numéro, String rue, String ville, int departement, String région) {
        Property property = new Property(numéro, rue, ville, departement, région);
    }
}
