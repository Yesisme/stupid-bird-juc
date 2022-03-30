package com.lym.juc.executor.cachedThread;

import lombok.SneakyThrows;

/**
 * @author yiming.le
 * @version 1.0.0
 * @ClassName TestCachedThread.java
 * @Description
 * @createTime 2022-03-30 21:24
 */
public class CachedThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程被调用了。");
        while (true){
            try{
                Thread.sleep(5000L);
                System.out.println(Thread.currentThread().getName());
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
