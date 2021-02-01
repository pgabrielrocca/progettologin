package com.example.progettologin2;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private String city;
    private String birthdate;
    private boolean admin;
    static private int id = 0;

    public User(String username, String password, String city, String birthdate, boolean admin, int id) {
        this.setUsername(username);
        this.setPassword(password);
        this.setCity(city);
        this.setBirthdate(birthdate);
        this.setAdmin(admin);
        this.setId(id);
    }

    public User(String username, String password, boolean admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;

    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        User.id = ++id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
