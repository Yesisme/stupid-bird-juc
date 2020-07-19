package com.lym.juc.md.waitNotify;

public class NotifyThread implements Runnable{

    private Object object;

    public NotifyThread(Object object){
        this.object = object;
    }
    @Override
    public void run() {
        synchronized (this.object){
            System.out.println(Thread.currentThread().getName()+"\t"+"come in");
            this.object.notify();
            System.out.println(Thread.currentThread().getName()+"\t"+"come out");
        }
    }
}
