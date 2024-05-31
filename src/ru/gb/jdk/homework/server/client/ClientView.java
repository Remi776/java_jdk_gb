package ru.gb.jdk.homework.server.client;

public interface ClientView {
    void showMessage(String message);

    void disconnectedFromServer();
    void setClientController(ClientController clientController);
}
