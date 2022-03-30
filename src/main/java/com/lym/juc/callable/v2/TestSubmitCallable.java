package com.lym.juc.callable.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author yiming.le
 * @version 1.0.0
 * @ClassName TestSubmitCallable.java
 * @Description
 * @createTime 2022-03-30 21:49
 */
public class TestSubmitCallable {

    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newCachedThreadPool();

        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final Future<String> future = executorService.submit(new SubmitCallable<>(i));
            list.add(future);
        }
        //正常执行
        for (Future<String> stringFuture : list) {
            try {
                final String result = stringFuture.get();
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            executorService.shutdown();
        }
    }
}
