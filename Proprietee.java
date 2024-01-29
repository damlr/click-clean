package com.click_and_clean;

public class Proprietee {
    private String adresse;
    private int num_adresse;
    private int surface;
    private String commentaire_proprietee;

    public Proprietee(String adresse, int num_adresse, String com_proprietee, int surface) {
        this.adresse = adresse;
        this.commentaire_proprietee = com_proprietee;
        this.num_adresse = num_adresse;
        this.surface = surface;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNum_adresse() {
        return num_adresse;
    }

    public void setNum_adresse(int num_adresse) {
        this.num_adresse = num_adresse;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public String getCommentaire_proprietee() {
        return commentaire_proprietee;
    }

    public void setCommentaire_proprietee(String commentaire_proprietee) {
        this.commentaire_proprietee = commentaire_proprietee;
    }
}
