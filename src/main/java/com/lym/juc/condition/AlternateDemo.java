package com.lym.juc.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AlternateDemo {

    public static void main(String[] args) {

        AbcAlternate abcAlternate = new AbcAlternate();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                abcAlternate.loopA(i);
            }

        },"A").start();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                abcAlternate.loopB(i);
            }
        },"B").start();


        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                abcAlternate.loopC(i);
                System.out.println("-----------------------------------------");
            }
        },"C").start();
    }
}

class AbcAlternate{

    private int num =1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void loopA(int totalLoop){

        lock.lock();
        try {
            //判断
            if(num!=1){
                condition1.await();
            }
            //打印

            for (int i = 1; i <=5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
            }

            num=2;
            //唤醒
            condition2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopB(int totalLoop){
        lock.lock();
        try {
            //判断
            if(num!=2){
                condition2.await();
            }
            //打印
            for (int i = 1; i <=10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
            }

            num=3;
            //唤醒
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC(int totalLoop){
        lock.lock();
        try {
            //判断
            if(num!=3){
                condition3.await();
            }
            //打印

            for (int i = 1; i <=15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
            }

            //唤醒
            num=1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}