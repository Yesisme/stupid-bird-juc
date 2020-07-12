package com.lym.juc.pc.v1;
public class Clerk {

    private int product = 0;

    //进货
    public synchronized void get() throws Exception {
        while(product>=1){
            System.out.println("产品已满");
            this.wait();
        }
        System.out.println(Thread.currentThread().getName()+"生产了第\t"+ ++product+"产品");
        this.notifyAll();
    }
    //缺货
    public synchronized void send() throws Exception {
        while(product<=0){
            System.out.println("缺货");
            this.wait();
        }
        System.out.println(Thread.currentThread().getName()+"消费了\t 剩"+ --product+"产品");
        this.notifyAll();
        }
}
