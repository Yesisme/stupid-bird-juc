package com.lym.juc.callable.v2;


import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author yiming.le
 * @version 1.0.0
 * @ClassName SubmitCallableError.java
 * @Description
 * @createTime 2022-03-30 22:04
 */
public class SubmitCallableError<T> implements Callable<String> {

    private int id;
    public SubmitCallableError(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        System.out.println("call()方法被自动调用,干活！！！             " + Thread.currentThread().getName());
        for (int i = 999999; i <= 0; i--);
        if (id==3){
            throw new TaskException("Meet error in task." + Thread.currentThread().getName());
        }
        return  ("call()方法被自动调用，任务的结果是：" + id + "    " + Thread.currentThread().getName());
    }
    public static class TaskException extends Exception{
       public TaskException(String message){
           super(message);
       }
    }
}
