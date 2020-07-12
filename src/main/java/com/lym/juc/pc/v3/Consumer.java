package com.lym.juc.pc.v3;

public class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        //模拟延迟
        for (int i = 0; i <10; i++) {
            try {
                Thread.sleep(30);
                clerk.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
