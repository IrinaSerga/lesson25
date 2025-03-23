package com.dmdev.lesson25;

public class ThreadDemo {

    public static void main(String[] args) {
        var simpleTread = new SimpleTread();
        System.out.println(simpleTread.getName() + ": " + simpleTread.getState());


        var simpleRunnable = new Thread(new SimpleRunnable(), "My name"); // создание потоков
        var threadLambda = new Thread(() -> System.out.println("Hello from lambda: " + Thread.currentThread().getName()));
        // запуск
        simpleTread.start();
        System.out.println(simpleTread.getName() + ": " + simpleTread.getState());
        simpleRunnable.start();
        threadLambda.start();


        try {
            // ожидание
            simpleTread.join(100L);
            System.out.println(simpleTread.getName() + ": " + simpleTread.getState());

            simpleRunnable.join();
            threadLambda.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //  simpleTread.interrupt();
        System.out.println(Thread.currentThread().getName()); // название потока
    }
}
