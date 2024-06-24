package ru.gb.jdk.collections.homework.entities;

import java.util.Objects;

public class Contact {
    private int id;
    private String phoneNumber;
    private String name;
    private double experience;

    public Contact(int id, String phoneNumber, String name, double experience) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return id == contact.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", phoneNumber: " + phoneNumber + '\'' +
                ", name: " + name + '\'' +
                ", experience: " + experience + '\'';
    }
}
