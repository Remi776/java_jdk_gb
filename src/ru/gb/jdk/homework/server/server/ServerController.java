package ru.gb.jdk.homework.server.server;

import ru.gb.jdk.homework.server.client.ClientController;
import ru.gb.jdk.homework.server.server.repository.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ServerController {
    private boolean isServerWorking;
    private ServerModes serverModes;
    private ServerView serverView;
    private Repository<String> repository;
    private List<ClientController> clientControllerList;

    public ServerController(ServerView serverView, Repository<String> repository) {
        this.serverView = serverView;
        this.repository = repository;
        clientControllerList = new ArrayList<>();
        serverView.setServerController(this);
    }

    public void start() {
        if (isServerWorking) {
            showOnWindow(ServerModes.ON.getDisplayMode());
        } else {
            isServerWorking = true;
            showOnWindow(ServerModes.ON.getDisplayMode() + "\t\t\t" + getDateFormat(LocalDateTime.now()));
        }
    }


    public void stop() {
        if (!isServerWorking) {
            showOnWindow(ServerModes.OFF.getDisplayMode());
        } else {
            isServerWorking = false;
            while (!clientControllerList.isEmpty()) {
                disconnectUser(clientControllerList.get(clientControllerList.size() - 1));
            }
            showOnWindow(ServerModes.OFF.getDisplayMode() + "\t\t\t" + getDateFormat(LocalDateTime.now()));
        }
    }

    public void disconnectUser(ClientController clientController){
        clientControllerList.remove(clientController);
        if (clientController != null){
            clientController.disconnectFromServer();
            showOnWindow(clientController.getName() + " disconnected");
        }
    }

    public boolean connectUser(ClientController clientController){
        if (!isServerWorking){
            return false;
        }
        clientControllerList.add(clientController);
        showOnWindow(clientController.getName() + " connected");
        return true;
    }

    public void message(String text){
        if (!isServerWorking){
            return;
        }
        showOnWindow(text);
        answerAll(text);
        saveInHistory(text);
    }

    public String getHistory(){
        return repository.load();
    }

    private void answerAll(String text){
        for (ClientController clientController : clientControllerList){
            clientController.answerFromServer(text);
        }
    }

    private void showOnWindow(String text) {
        serverView.showMessage(text + "\n");
    }

    private void saveInHistory(String text){
        repository.save(text);
    }
    private String getDateFormat(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(formatter);
    }
}
