package com.lym.juc.pc.v3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Clerk {

    private int count =0;

    private Lock lock = new ReentrantLock();

    Condition fullCondition = lock.newCondition();

    Condition emptyCondition = lock.newCondition();


    /*取货*/
    public void get(){
        lock.lock();
        try {
            while(count>=10){
                System.out.println("产品已满！");
                fullCondition.await();
            }
            System.out.println(Thread.currentThread().getName()+"\t生产了"+ ++count+"商品");
            emptyCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //生产货
    public void put(){
        lock.lock();
        try {
            while(count<=0){
                System.out.println("产品不足缺货中！");
                emptyCondition.await();
            }
            System.out.println(Thread.currentThread().getName()+"\t消费了"+"还剩"+ --count+"商品");
            fullCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
