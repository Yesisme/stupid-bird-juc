package com.lym.juc.md.monitor;
//锁的对象相同和线程的执行顺序和代码的顺序一致
public class MonitorDemo {

    public static void main(String[] args) throws InterruptedException {
        Numer numer1  = new Numer();

        Numer numer2 = new Numer();

        Thread t1 = new Thread(() -> {
            numer1.getOne();
        });

        Thread t2 = new Thread(() -> {
            numer1.getTwo();
        });

        Thread t3 = new Thread(() -> {
            numer2.getThree();
        });

        t1.start();
        t2.start();
        t3.start();



        /*new Thread(() -> {
            numer1.getOne();
        }).start();

         new Thread(() -> {
            numer1.getTwo();
        }).start();

        new Thread(() -> {
            numer2.getThree();
        }).start();*/


    }
}

class Numer{

    public synchronized void getOne(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public  synchronized void getTwo(){
        System.out.println("two");
    }

    public synchronized void getThree(){
        System.out.println("three");
    }
}
