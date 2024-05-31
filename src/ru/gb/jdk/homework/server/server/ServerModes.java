package ru.gb.jdk.homework.server.server;

public enum ServerModes {
    ON("Server is running"), OFF("Server is stopped");

    private final String displayMode;

    ServerModes(String displayMode) {
        this.displayMode = displayMode;
    }

    public String getDisplayMode() {
        return displayMode;
    }
}
