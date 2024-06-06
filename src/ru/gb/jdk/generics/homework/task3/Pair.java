package ru.gb.jdk.generics.homework.task3;

public class Pair <T, V> {
    T t;
    V v;

    public Pair(T t, V v) {
        this.t = t;
        this.v = v;
    }

    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    @Override
    public String toString() {
        return "Pair{\n" +
                "t: " + t.getClass().getSimpleName() +
                "\nv: " + v.getClass().getSimpleName() +
                "\n}";
    }
}
