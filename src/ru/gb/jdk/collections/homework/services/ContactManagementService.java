package ru.gb.jdk.collections.homework.services;

import ru.gb.jdk.collections.homework.entities.Contact;

import java.util.ArrayList;
import java.util.Scanner;

public interface ContactManagementService {
    void printContacts();
    void addContact(Scanner scn);
    void searchContactByExperience(Scanner scn);
    void searchPhoneByName(Scanner scn);
    void searchContactByID(Scanner scn);
}
