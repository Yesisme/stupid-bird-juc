package com.lym.juc.md.waitNotify;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Test object = new Test();
        new Thread(new WaitThread(object),"A").start();

        new Thread(new NotifyThread(object),"B").start();
    }
}
