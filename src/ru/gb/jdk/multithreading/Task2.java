package ru.gb.jdk.multithreading;

//    Создайте два потока A и B.
//    Поток A меняет значение Boolean переменной switcher с задержкой 1000 миллисекунд
//    (true в состояние false и наоборот).
//    Поток B ожидает состояния true переменной switcher и выводит на консоль обратный отсчет от 100
//    с задержкой 100 миллисекунд и приостанавливает свое действие, как только поток A переключит switcher
//    в состояние false.
//    Условием завершения работы потоков является достижение отсчета нулевой отметки.
//    Можно воспользоваться синхронизацией для управления значения переменной или volatile
public class Task2 {
    static volatile Boolean switcher = false;

    public static void main(String[] args) {
        Thread changer = new Thread(() -> {
            while (true){
                switcher = !switcher;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread counter = new Thread(() -> {
            int count = 100;
            while (count >= 0){
                if (switcher){
                    System.out.println(Thread.currentThread().getName() + " " + count--);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        changer.start();
        counter.start();
    }
}
