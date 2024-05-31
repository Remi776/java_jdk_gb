package ru.gb.jdk.collections;


import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Map<String, String> phoneBook = createMap();
        List<Map.Entry<String, String>> list = new ArrayList<>(phoneBook.entrySet());
        list.sort(Map.Entry.comparingByValue());

    }

    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("+151234567", "Kate");
        map.put("+8153214567", "John");
        map.put("+64567832", "Bob");
        map.put("+79157832", "Alex");
        map.put("+8912", "Clark");
        map.put("+74422", "Bob");
        return map;
    }

    public static void sortByNameLength(Map<String, String> map) {

    }
}
