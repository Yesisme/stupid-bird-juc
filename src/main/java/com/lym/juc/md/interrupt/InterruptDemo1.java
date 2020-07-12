package com.lym.juc.md.interrupt;

public class InterruptDemo1 {

    public static void main(String[] args) throws InterruptedException {
        Runnable interruptTask = new Runnable() {
            int i;
            @Override
            public void run() {
                try {
                    while(!Thread.currentThread().isInterrupted()){
                        Thread.sleep(100);
                        i++;
                        System.out.println(Thread.currentThread().getName()+"loop:("+Thread.currentThread().getState()+")");
                    }
                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getName()+"catch interruptException:("+Thread.currentThread().getState()+")");
                }
            }
        };


        Thread t1 = new Thread(interruptTask);
        System.out.println(t1.getName()+"("+t1.getState()+")"+"is new.");
        t1.start();
        System.out.println(t1.getName()+"("+t1.getState()+")"+"is start.");
        Thread.sleep(300);
        t1.interrupt();
        System.out.println(t1.getName()+"("+t1.getState()+")"+"is intterrupt.");
        Thread.sleep(300);
        System.out.println(t1.getName()+"("+t1.getState()+")"+"is intterrupt now.");
    }
}
