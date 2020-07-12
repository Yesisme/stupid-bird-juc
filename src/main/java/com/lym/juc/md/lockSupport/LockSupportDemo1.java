package com.lym.juc.md.lockSupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo1 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (i == 5) {
                    LockSupport.park();
                }
            }
        });
        t.start();

        TimeUnit.SECONDS.sleep(8);
        System.out.println("八秒钟之后");
        LockSupport.unpark(t);

    }
}
