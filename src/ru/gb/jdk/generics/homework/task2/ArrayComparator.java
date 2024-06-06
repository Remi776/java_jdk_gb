package ru.gb.jdk.generics.homework.task2;

public class ArrayComparator {
    public static <T> boolean compareArrays(T[] array1, T[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] integers1 = {1, 2, 3};
        Integer[] integers2 = {1, 2, 3};
        Integer[] integers3 = {4, 5, 6};

        Double[] doubles1 = {1.3, 2.2, 3.1};
        Double[] doubles2 = {1.3, 2.2, 3.1};
        Double[] doubles3 = {4.0, 5.1, 6.2};

        String[] strings1 = {"Hello", "my", "friend"};
        String[] strings2 = {"Hello", "my", "friend"};
        String[] strings3 = {"a", "b", "c"};

        System.out.println(compareArrays(integers1, integers3));
        System.out.println(compareArrays(doubles1, doubles2));
        System.out.println(compareArrays(strings1, strings3));
    }

}
