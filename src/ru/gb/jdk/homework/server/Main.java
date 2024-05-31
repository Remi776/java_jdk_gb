package ru.gb.jdk.homework.server;

import ru.gb.jdk.homework.server.client.ClientController;
import ru.gb.jdk.homework.server.client.ClientGUI;
import ru.gb.jdk.homework.server.server.ServerController;
import ru.gb.jdk.homework.server.server.ServerView;
import ru.gb.jdk.homework.server.server.ServerWindow;
import ru.gb.jdk.homework.server.server.repository.FileHandler;

public class Main {
    public static void main(String[] args) {
        ServerController serverController = new ServerController(new ServerWindow(), new FileHandler());

        new ClientController(new ClientGUI(), serverController);
        new ClientController(new ClientGUI(), serverController);
    }
}
