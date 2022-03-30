package com.lym.juc.cas.lock;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁demo验证
 */
public class SpinLock {

    AtomicReference<Thread> ar = new AtomicReference<>();

    public void lock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t"+"come in");
        while(!ar.compareAndSet(null,thread)){}
    }

    public void unlock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t"+"come out");
        ar.compareAndSet(thread,null);
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLock spinLock = new SpinLock();
        new Thread(()->{
            spinLock.lock();
            try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
            spinLock.unlock();
        },"A").start();

        Thread.sleep(1000);

        new Thread(()->{
            spinLock.lock();
            spinLock.unlock();
        },"B").start();
    }
}
