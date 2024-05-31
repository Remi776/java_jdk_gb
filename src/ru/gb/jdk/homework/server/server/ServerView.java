package ru.gb.jdk.homework.server.server;

public interface ServerView {
    void showMessage(String message);
    void setServerController(ServerController serverController);
}
