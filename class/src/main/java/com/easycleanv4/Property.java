package com.easycleanv4;

public class Property {
    private String adress;
    private int num_adress;
    private int surface;
    private String commentary_property;

    public Property(String adress, int num_adress, String com_property, int surface) {
        this.adress = adress;
        this.commentary_property = com_property;
        this.num_adress = num_adress;
        this.surface = surface;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getNum_adress() {
        return num_adress;
    }

    public void setNum_adress(int num_adress) {
        this.num_adress = num_adress;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public String getCommentaire_proprietee() {
        return commentary_property;
    }

    public void setCommentaire_proprietee(String commentaire_proprietee) {
        this.commentary_property = commentaire_proprietee;
    }
}
