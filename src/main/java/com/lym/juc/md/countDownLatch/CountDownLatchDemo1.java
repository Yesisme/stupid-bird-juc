package com.lym.juc.md.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo1 {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        new Thread(()->{
            System.out.println("挂号");
            latch.countDown();
        },"A").start();

        new Thread(()->{
            System.out.println("看病");
            latch.countDown();
        },"B").start();


        new Thread(()->{
            System.out.println("拿药");
            latch.countDown();
        },"C").start();

        latch.await();



        //System.out.println("回家");

    }
}
