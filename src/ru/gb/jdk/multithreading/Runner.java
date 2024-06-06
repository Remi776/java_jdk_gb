package ru.gb.jdk.multithreading;

import java.util.Random;

public class Runner extends Thread {
    private String name;
    private static Random random = new Random();

    public Runner(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            goToStart();
            runToFinish();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToStart() throws InterruptedException {
        System.out.println(name + " движется к линии старта");
        sleep(random.nextLong(1000, 3000));
        System.out.println(name + " пришел на линию старта");
    }

    public void runToFinish() throws InterruptedException {
        System.out.println(name + " бежит к линии финиша");
        sleep(random.nextLong(1000, 3000));
        System.out.println(name + " финишировал");
    }
}
