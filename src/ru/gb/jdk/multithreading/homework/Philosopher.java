package ru.gb.jdk.multithreading.homework;

public class Philosopher implements Runnable {
    private Object leftFork;
    private Object rightFork;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep((int) (Math.random() * 100));
    }


    @Override
    public void run() {
        try {
            while (true){
                doAction(System.nanoTime() + " : thinking...");
                synchronized (leftFork){
                    doAction(System.nanoTime() + " : picked up left fork...");
                    synchronized (rightFork){
                        doAction(System.nanoTime() + " : picked up right fork... EATING");
                        doAction(System.nanoTime() + " : put down right fork...");
                    }

                    doAction(System.nanoTime() + " : put down left fork... thinking again...");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
