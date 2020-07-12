package com.lym.juc.md.reentrant.v2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantTryLockDemo {

    ReentrantLock lock = new ReentrantLock();
    void m1(){
        lock.lock();
        try {
            for (int i = 0; i <8 ; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /*使用tryLock进行尝试锁定，不管锁定与否，方法都将继续执行*/
    /*void m2(){
        boolean locked = lock.tryLock();
        System.out.println("m2");
        if(locked)lock.unlock();
    }*/

    void m2(){
        boolean locked = false;
        try {
            locked = lock.tryLock(5,TimeUnit.SECONDS);
            System.out.println("m2:"+locked);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(locked)lock.unlock();
        }
    }


    public static void main(String[] args) {
        ReentrantTryLockDemo rt = new ReentrantTryLockDemo();
        new Thread(rt::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(rt::m2).start();
    }
}
