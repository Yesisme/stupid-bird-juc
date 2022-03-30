package com.lym.juc.callable.v2;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author yiming.le
 * @version 1.0.0
 * @ClassName TestSubmitCallableErrot.java
 * @Description
 * @createTime 2022-03-30 22:23
 */
public class TestSubmitCallableError {

    public static void main(String[] args) {

        final ExecutorService executorService = Executors.newCachedThreadPool();
        final ArrayList<Future<String>> list2 = new ArrayList<>();
        //异常执行
        for (int i = 0; i < 10; i++) {
            final Future<String> submit = executorService.submit(new SubmitCallableError<>(i));
            list2.add(submit);
        }
        for (Future<String> stringFuture : list2) {
            try {
                System.out.println(stringFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
                executorService.shutdownNow();
                return;
            }
        }
    }
}
