package com.lym.juc.md.reentrant.v1;
/*
*
*/
public class SynchronizedDemo {

    synchronized void m1(){
        for (int i = 0; i <10 ; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

     synchronized void m2(){
        System.out.println("m2.......");
    }

    public static void main(String[] args) {
        SynchronizedDemo sd = new SynchronizedDemo();
        //默认锁的对象this,当前线程争抢到了cpu使用权
        new Thread(sd::m1,"t1").start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //必须等t1执行完
        new Thread(sd::m2,"t2").start();
    }
}
