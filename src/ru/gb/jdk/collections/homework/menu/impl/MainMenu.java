package ru.gb.jdk.collections.homework.menu.impl;

import ru.gb.jdk.collections.homework.menu.Menu;
import ru.gb.jdk.collections.homework.services.ContactManagementService;
import ru.gb.jdk.collections.homework.services.impl.DefaultContactManagementService;

import java.util.Scanner;

public class MainMenu implements Menu {
    private static final String MENU_COMMAND = "menu";
    private static final String MENU_EXIT = "exit";
    private static final String MENU_TEXT = "1. Получить список сотрудников" + System.lineSeparator() + "2. Поиск по стажу"
            + System.lineSeparator() + "3. Поиск номера телефона по имени" + System.lineSeparator() + "4. Поиск по ID"
            + System.lineSeparator() + "5. Добавить нового сотрудника" + System.lineSeparator() + "for EXIT enter 'exit'";

    private ContactManagementService contactManagementService;

    {
        contactManagementService = new DefaultContactManagementService();
    }

    @Override
    public void start() {
        while (true) {
            printHeader();
            Scanner sc = new Scanner(System.in);
            System.out.println("User input: ");
            String userInput = sc.next();
            if (userInput.equalsIgnoreCase(MENU_EXIT)){
                System.exit(0);
            } else {
                switch (userInput) {
                    case "1" -> contactManagementService.printContacts();
                    case "2" -> contactManagementService.searchContactByExperience(sc);
                    case "3" -> contactManagementService.searchPhoneByName(sc);
                    case "4" -> contactManagementService.searchContactByID(sc);
                    case "5" -> contactManagementService.addContact(sc);
                    default -> System.out.println("Only 1, 2, 3, 4, 5 is allowed. Try one more time");
                }
            }
        }
    }

    @Override
    public void printHeader() {
        System.out.println("===== MAIN MENU =====");
        System.out.println(MENU_TEXT);
    }
}
