package com.lym.juc.lvolatile;

public class VoltaileDemo {

    public static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            //休眠让mian线程知道flag=true
            try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace();}
            flag =true;
            System.out.println(Thread.currentThread().getName()+":已经改了falg\t"+flag);
        },"A").start();

        while (true){
            //不加volatile synchronized可以从主内存中强制读取
            synchronized (VoltaileDemo.class){
                if(flag){
                    System.out.println(Thread.currentThread().getName()+":flag已变成true");
                    break;
                }
            }

        }
    }
}
