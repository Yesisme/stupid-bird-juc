package com.lym.juc.pc.v3;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Clerk clerk = new Clerk();

        Thread t1 = new Thread(new Productor(clerk),"p1");
        t1.start();


        Thread t2 = new Thread(new Consumer(clerk),"c1");
        Thread t3 = new Thread(new Consumer(clerk),"c2");
        t2.start();
        t3.start();
    }
}
