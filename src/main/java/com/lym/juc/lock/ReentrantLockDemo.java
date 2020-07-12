package com.lym.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo implements Runnable {

    private static int ticket = 100;

    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                if (ticket > 0) {
                    try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace();}
                    System.out.println("正在售卖第" + ticket-- + "张票");
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo rt = new ReentrantLockDemo();
        for (int i = 0; i < 3; i++) {
            new Thread(rt).start();
        }
    }
}
