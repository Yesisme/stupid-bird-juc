package com.lym.juc.md.countDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo2 {

    volatile List list = new ArrayList();

    public void add(Object o){
        list.add(o);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo2 cdd = new CountDownLatchDemo2();

        CountDownLatch cd = new CountDownLatch(1);

        new Thread(() -> {
            if (cdd.size() != 5) {
                try {
                    cd.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2结束");
        }, "t2").start();

        Thread.sleep(1000);

        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                cdd.add(i);
                System.out.println(i);
                if (cdd.size() == 5) {
                    cd.countDown();
                }
                /*不休眠是有问题的*/
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

    }
}
