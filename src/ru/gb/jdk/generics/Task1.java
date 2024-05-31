package ru.gb.jdk.generics;

import java.io.DataInput;
import java.io.InputStream;


public class Task1<T extends Comparable<T>, V extends InputStream & DataInput, K extends Number> {
    private T t;
    private V v;
    private K k;

    public Task1(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    public K getK() {
        return k;
    }

    public void printClassNames(){
        System.out.printf("T: %s, V: %s, K: %s", t.getClass().getName(), v.getClass().getName(), k.getClass().getName());
    }
}
