package com.lym.juc.pc.v1;


public class Test {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);

        new Thread(productor,"生产者A").start();

        new Thread(consumer,"消费者B").start();

        new Thread(productor,"生产者C").start();

        new Thread(consumer,"消费者D").start();
    }
}

