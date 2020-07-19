package com.lym.juc.md.waitNotify;

public class WaitThread implements Runnable{

    private Object object;
    public WaitThread(Object object){
     this.object = object;
    }
    @Override
    public void run() {

        synchronized (this.object){
            System.out.println(Thread.currentThread().getName()+"\t"+"come in");
            try {
                this.object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"\t"+"come out");
        }
    }
}
