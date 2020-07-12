package com.lym.juc.pc.v2;

public class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            //模拟延迟
            try {
                Thread.sleep(200);
                clerk.send();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
