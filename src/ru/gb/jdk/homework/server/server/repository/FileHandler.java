package ru.gb.jdk.homework.server.server.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements Repository<String>{
    public static final String LOG_PATH = "src/ru/gb/jdk/homework/server/log.txt";
    @Override
    public void save(String text) {
        try (FileWriter fileWriter = new FileWriter(LOG_PATH, true)) {
            fileWriter.write(text);
            fileWriter.write("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String load() {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(LOG_PATH))) {
            String str;
            while ((str = br.readLine()) != null) {
                stringBuilder.append(str).append("\n");
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
