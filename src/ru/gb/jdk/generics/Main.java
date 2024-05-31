package ru.gb.jdk.generics;

public class Main {
    public static void main(String[] args) {
        GenericCollectionClass<String> strings = new GenericCollectionClass<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("D");

        System.out.println(strings);

        strings.remove(2);
        System.out.println(strings);

    }
}
