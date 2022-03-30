package com.lym.juc.executor.cachedThread;

import com.lym.juc.executor.cachedThread.CachedThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yiming.le
 * @version 1.0.0
 * @ClassName TestCachedThread.java
 * @Description
 * @createTime 2022-03-30 21:24
 */
public class TestCachedThread {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.execute(new CachedThread());
            System.out.println( "************* a" + i + " *************");
        }
        executor.shutdown();
    }
}
