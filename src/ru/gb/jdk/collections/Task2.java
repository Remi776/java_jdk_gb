package ru.gb.jdk.collections;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Set<String> setNames = new HashSet<>(createListNames());
        String smallestName = Collections.min(setNames);
        String largestName = Collections.max(setNames, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = Integer.compare(o2.length(), o1.length());
                return result != 0 ? result : o1.compareTo(o2);
            }
        });


    }

    private static List<String> createListNames(){
        List<String> humanNames = new ArrayList<>();
        humanNames.add("Kate");
        humanNames.add("John");
        humanNames.add("Bob");
        humanNames.add("Bob");
        humanNames.add("Clark");
        humanNames.add("Alex");
        humanNames.add("Alex");
        return humanNames;
    }
}
