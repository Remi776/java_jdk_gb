package ru.gb.jdk.collections.homework.services.impl;

import ru.gb.jdk.collections.homework.entities.Contact;
import ru.gb.jdk.collections.homework.services.ContactManagementService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DefaultContactManagementService implements ContactManagementService {
    private static List<Contact> contacts;

    static {
        initContacts();
    }

    private static void initContacts() {
        contacts = new ArrayList<>(Arrays.asList(
                new Contact(1, "123-456-7890", "Alice", 5),
                new Contact(2, "234-567-8901", "Bob", 3),
                new Contact(3, "345-678-9012", "Charlie", 7),
                new Contact(4, "456-789-0123", "David", 2),
                new Contact(5, "567-890-1234", "Eve", 4),
                new Contact(6, "678-901-2345", "Frank", 6),
                new Contact(7, "789-012-3456", "Grace", 1),
                new Contact(8, "890-123-4567", "Hank", 8),
                new Contact(9, "901-234-5678", "Ivy", 9),
                new Contact(10, "012-345-6789", "Jack", 10)
        ));
    }

    @Override
    public void printContacts() {
        contacts.forEach(contact -> System.out.println(contact));
    }

    @Override
    public void addContact(Scanner scn) {
        System.out.println("Введите ID: ");
        int id = scn.nextInt();
        System.out.println("Введите номер телефона: ");
        String phoneNumber = scn.next();
        System.out.println("Введите имя: ");
        String name = scn.next();
        System.out.println("Введите опыт работы: ");
        double experience = scn.nextDouble();
        contacts.add(new Contact(id, phoneNumber, name, experience));
    }

    @Override
    public void searchContactByExperience(Scanner scn) {
        System.out.println("Введите стаж: ");
        double userInput = scn.nextDouble();
        for (Contact contact : contacts){
            if (contact.getExperience() == userInput){
                System.out.println(contact);
            }
        }
    }

    @Override
    public void searchPhoneByName(Scanner scn) {
        System.out.println("Введите имя контакта: ");
        String userInput = scn.next();
        for (Contact contact : contacts){
            if (contact.getName().equalsIgnoreCase(userInput)){
                System.out.println(contact.getName() + " : " + contact.getPhoneNumber());
            }
        }
    }

    @Override
    public void searchContactByID(Scanner scn) {
        System.out.println("Введите ID контакта: ");
        int userInput = scn.nextInt();
        for (Contact contact : contacts){
            if (contact.getId() == userInput){
                System.out.println(contact);
            }
        }
    }
}
