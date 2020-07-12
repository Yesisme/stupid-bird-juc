package com.lym.juc.md.reentrant.v1;
/*
synchronized可重入锁验证
*/
public class SynchronizedReentrantDemo {

    synchronized void m1(){
        for (int i = 0; i <10 ; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i==3){
                m2();
            }
            System.out.println(i);
        }
    }

    synchronized void m2(){
        System.out.println("m2.......");
    }

    public static void main(String[] args) {
        SynchronizedReentrantDemo sd = new SynchronizedReentrantDemo();
        new Thread(sd::m1,"t1").start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
