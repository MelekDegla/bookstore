package com.vermeg.bookstore.service.implementation;

public class PassingDataService {

    private static PassingDataService INSTANCE;
public static String email;
public static int id;
    private static String txtValue;

    private PassingDataService(){

    }

    public static PassingDataService getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new PassingDataService();
        }

        return INSTANCE;
    }

    public static void setData(String txt) {
        txtValue = txt;
    }

    public String getData() {
        return this.txtValue;
    }


}
