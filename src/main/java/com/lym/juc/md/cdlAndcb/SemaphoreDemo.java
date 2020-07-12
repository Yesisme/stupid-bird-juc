package com.lym.juc.md.cdlAndcb;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {


     static class Car extends Thread{

         private int num;

         private Semaphore semaphore;

         public Car(int num, Semaphore semaphore) {
             this.num=num;
             this.semaphore=semaphore;
         }

         @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("第"+num+"辆车获取了车位");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             System.out.println("第"+num+"辆车开走了回家吃饭了");
            semaphore.release();
        }
    }

    public static void main(String[] args) {
         Semaphore se = new Semaphore(5);
        for (int i = 1; i <= 15; i++) {
            new Thread(new Car(i,se)).start();
        }
    }

}
