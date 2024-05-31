package ru.gb.jdk.homework.server.server.repository;

public interface Repository<T> {
    void save(T text);
    T load();
}
