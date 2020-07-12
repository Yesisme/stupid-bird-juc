package com.lym.juc.cas.v2;

import java.util.concurrent.atomic.AtomicInteger;
/*AtomicInteger保证原子性*/
public class AtomicDemo {

    static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        AtomicDemo ai = new AtomicDemo();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    atomicInteger.getAndIncrement();
                }
            }).start();
        }
        while (Thread.activeCount()>2)Thread.yield();
        System.out.println("num:\t"+atomicInteger.get());
    }
}
