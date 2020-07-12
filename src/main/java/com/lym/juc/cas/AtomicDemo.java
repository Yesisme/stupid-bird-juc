package com.lym.juc.cas;
/*volatile不保证原子性说明*/
public class AtomicDemo {

    private volatile int num =0;

    public void incrementNum(){
        num++;
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicDemo ai = new AtomicDemo();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    ai.incrementNum();
                }
            }).start();

        }
        while (Thread.activeCount()>2)Thread.yield();
        System.out.println("num:\t"+ai.num);
    }
}
