package com.example.userstorage2;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable, Comparable<User> {
    private String firstName;
    private String lastName;
    private String email;
    private String degreeProgram;
    private ArrayList<String> completedDegrees;

    public User(String firstName, String lastName, String email, String degreeProgram, ArrayList<String> completedDegrees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.completedDegrees = new ArrayList<>(completedDegrees);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDegreeProgram() {
        return degreeProgram;
    }

    public ArrayList<String> getCompletedDegrees() {
        return completedDegrees;
    }

    @Override
    public int compareTo(User u) {
        return this.getLastName().compareTo(u.getLastName());
    }
}
