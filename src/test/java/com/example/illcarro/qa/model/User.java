package com.example.illcarro.qa.model;

public class User {
    private  String name;
    private  String surname;
    private  String email;
    private  String password;


    public User withName(String name) {
        this.name = name;
        return this;
    }

    public User withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
