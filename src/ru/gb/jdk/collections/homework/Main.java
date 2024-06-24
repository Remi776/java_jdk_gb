package ru.gb.jdk.collections.homework;

import ru.gb.jdk.collections.homework.menu.Menu;
import ru.gb.jdk.collections.homework.menu.impl.MainMenu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new MainMenu();
        menu.start();
    }
}
