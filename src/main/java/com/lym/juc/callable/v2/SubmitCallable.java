package com.lym.juc.callable.v2;

import java.util.concurrent.Callable;

/**
 * @author yiming.le
 * @version 1.0.0
 * @ClassName SubmitCallable.java
 * @Description
 * @createTime 2022-03-30 21:45
 */
public class SubmitCallable<T> implements Callable<T> {
    private int orderId;

    public SubmitCallable(int orderId){
        this.orderId = orderId;
    }
    @Override
    public T call() throws Exception {
        System.out.println("call()方法被自动调用,干活！！！             " + Thread.currentThread().getName());
        for (int i = 999999; i <= 0; i--);
        return (T) ("call()方法被自动调用，任务的结果是：" + orderId + "    " + Thread.currentThread().getName());
    }
}
