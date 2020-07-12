package com.lym.juc.md.join;

public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1,t2,t3 ;

        t1 = new Thread(() -> {
            System.out.println("A");
        },"A");

        t2 = new Thread(() -> {
            System.out.println("B");
        },"B");

        t3 = new Thread(() -> {
            System.out.println("C");
        },"C");

        t3.start();
        t3.join();
        t1.start();
        t1.join();
        t2.start();
        t2.join();
    }
}
