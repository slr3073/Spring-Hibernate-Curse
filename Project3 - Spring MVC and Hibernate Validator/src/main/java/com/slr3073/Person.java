package com.slr3073;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Person {
    private String firstName;
    private String lastName;
    private String country;
    private final LinkedHashMap<String,String> COUNTRY_OPTIONS = new LinkedHashMap<>();
    private String favoriteLanguage;
    private ArrayList<String> os = new ArrayList<>();

    public Person(){
        COUNTRY_OPTIONS.put("FR","France");
        COUNTRY_OPTIONS.put("US","Etats unis");
        COUNTRY_OPTIONS.put("ITA","Italie");
        COUNTRY_OPTIONS.put("ES","Espagne");
        COUNTRY_OPTIONS.put("RO","Roumanie");
    }

    public LinkedHashMap<String, String> getCOUNTRY_OPTIONS() {
        return COUNTRY_OPTIONS;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public ArrayList<String> getOs() {
        return os;
    }

    public void setOs(ArrayList<String> os) {
        this.os = os;
    }
}
