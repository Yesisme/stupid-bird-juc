package com.lym.juc.md.lockSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo2 {

    volatile List list = new ArrayList();

    private void add(Object o){
        list.add(o);
    }

    private int size(){
        return list.size();
    }
    static Thread t1,t2;

    public static void main(String[] args) throws InterruptedException {
        LockSupportDemo2 ls= new LockSupportDemo2();

        t1=new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                ls.add(i);
                System.out.println("add\t"+i);
                if(ls.size()==5){
                    LockSupport.unpark(t2);
                    LockSupport.park();

                }
            }
        },"t1");

        Thread.sleep(1000);

        t2=new Thread(()->{
            LockSupport.park();
            System.out.println("t2 结束");
            LockSupport.unpark(t1);

        },"t2");

        t2.start();
        t1.start();
    }
}
