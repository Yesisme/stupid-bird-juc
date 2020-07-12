package com.lym.juc.md.reentrant.v2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
ReentrantLock测试
* */
public class ReentrantLockThisDemo {

    //锁的对象是this
    Lock lock = new ReentrantLock();

    void m1() {
        lock.lock();
        try {
            for (int i = 0; i <10 ; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void m2(){
        lock.lock();
        try {
            System.out.println("m2.....");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockThisDemo rt = new ReentrantLockThisDemo();
        //当前线程获取到cpu执行权，必须等此线程执行完成
        new Thread(rt::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(rt::m2).start();
    }
}
