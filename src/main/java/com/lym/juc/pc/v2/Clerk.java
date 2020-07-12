package com.lym.juc.pc.v2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Clerk {

    private int product = 0;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    //进货
    public void get() throws Exception {
        lock.lock();
        try {
            while(product>=10){
                System.out.println("产品已满");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+"生产了第\t"+ ++product+"产品");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
    //缺货
    public  void send() throws Exception {

        lock.lock();
        try {
            while(product<=0){
                System.out.println("缺货");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+"消费了\t 剩"+ --product+"产品");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

}
