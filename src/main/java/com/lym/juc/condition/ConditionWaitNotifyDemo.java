package com.lym.juc.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yiming.le
 * @version 1.0.0
 * @ClassName ConditionWaitNotifyDemo.java
 * @Description
 * @createTime 2021-08-02 23:56
 */
public class ConditionWaitNotifyDemo {

    static Object object = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {

        new Thread(()->{
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+"==========come in");
                condition.await();
                System.out.println(Thread.currentThread().getName()+"==========come in");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"A").start();


        new Thread(()->{
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+"=================通知");
                condition.signal();
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"B").start();
    }
}
