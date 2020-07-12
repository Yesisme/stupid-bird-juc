package com.lym.juc.pc.v2;

public class Productor implements Runnable{

    private Clerk clerk;

    public Productor(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                clerk.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
