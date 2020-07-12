package com.lym.juc.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
//读写，写写互斥，读读不互斥
public class ReentrantWriteReadLockDemo {

    private Map<Object,Object> map = new HashMap<>();

    ReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws InterruptedException {

        ReentrantWriteReadLockDemo wrLock = new ReentrantWriteReadLockDemo();

        for (int i = 1; i <=5 ; i++) {
            final int temp =i;
            new Thread(()->{
                wrLock.write(temp,"v"+temp);
            }).start();
        }

        Thread.sleep(10);

        for (int i = 1; i <= 5; i++) {
            final int temp =i;
            new Thread(()->{
                wrLock.read(temp);
            }).start();
        }
    }

    public void write(Object key,Object value){
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+"正在写入\t"+""+key+":"+value);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入完成\t"+""+key+":"+value);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void read(Object key){
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+"正在读取\t"+key);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取完成\t"+result);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }
}
