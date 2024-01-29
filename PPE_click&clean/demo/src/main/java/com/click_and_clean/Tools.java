package com.click_and_clean;

public class Tools {
    /** attributs */
    private int nb_cleaners;
    private int nb_owners;
    private int nb_mission_area;

    public Tools(int nb_cleaners, int nb_owners, int nb_mission_area) {
        this.nb_cleaners = nb_cleaners;
        this.nb_owners = nb_owners;
        this.nb_mission_area = nb_mission_area;
    }

    public int getNb_cleaners() {
        return nb_cleaners;
    }

    public void setNb_cleaners(int nb_cleaners) {
        this.nb_cleaners = nb_cleaners;
    }

    public int getNb_owners() {
        return nb_owners;
    }

    public void setNb_owners(int nb_owners) {
        this.nb_owners = nb_owners;
    }

    public int getNb_mission_area() {
        return nb_mission_area;
    }

    public void setNb_mission_area(int nb_mission_area) {
        this.nb_mission_area = nb_mission_area;
    }

    /** method pour calculer les nombres de mission sur le site */
    public void count_mission() {

    }

    /** method pour calculer le nombre de mission dans la zone */
    public void count_mission_area() {

    }
}
