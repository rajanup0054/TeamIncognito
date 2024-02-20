package com.example.medidoc;

// Specialist.java
public class Specialist {
    private String type;
    private String fullName;
    private int age;
    private String email;
    private int experience;

    // Empty constructor (required by Firebase)
    public Specialist() {
    }

    public Specialist(String type, String fullName, int age, String email, int experience) {
        this.type = type;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.experience = experience;
    }

    // Add getters and setters as needed
}
