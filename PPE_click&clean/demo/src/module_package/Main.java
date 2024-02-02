package com.click_and_clean;

public class Main {
    public static void main(String[] args) {
        DAOacces dao = new DAOacces("testPPE", "dam", "root");

       // Property property = new Property();
       //dao.addDAO(property);

        Property property2 = new Property(1)
        property2.setId(2);
        dao.deleteDAO(property2);

        dao.disconnect();
    }
}
