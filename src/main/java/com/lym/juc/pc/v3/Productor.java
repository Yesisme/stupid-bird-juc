package com.lym.juc.pc.v3;

public class Productor implements Runnable{

    private Clerk clerk;

    public Productor (Clerk clerk){
        this.clerk = clerk;
    }


    @Override
    public void run() {
        for (int i = 0; i <20; i++) {
            try {
                Thread.sleep(20);
                clerk.put();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
