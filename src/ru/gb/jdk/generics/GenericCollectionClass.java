package ru.gb.jdk.generics;

import java.util.Iterator;

public class GenericCollectionClass<T> implements Iterable<T>{

    private static final int DEFAULT_SIZE = 10;
    int size;
    Object[] array;

    public GenericCollectionClass() {
        array = new Object[DEFAULT_SIZE];
    }

    public void add(T t){
        if (size == array.length){
            Object[] newArray = new Object[size << 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
        }
        array[size++] = t;
    }

    public void remove(int index){
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (T t : this){
            str.append(t).append(" ");
        }
        return "GenericCollectionClass{" +
                "size= " + size +
                ", array= " + str +
                '}';
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private int index;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T) array[index++];
            }
        };
    }
}
