package com.lym.juc.lock;

public class DeadLockDemo {

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        new Thread(() -> {
            synchronized (obj1) {
                System.out.println(Thread.currentThread().getName() + "\t" + "获取锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println(Thread.currentThread().getName() + "\t" + "获取锁");
                }
            }
        }, "A").start();

        new Thread(()->{
                synchronized (obj2){
                    System.out.println(Thread.currentThread().getName()+"\t"+"获取了锁");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj1){
                        System.out.println(Thread.currentThread().getName()+"\t"+"获取了锁");
                    }
                }
        },"B").start();

    }
}
