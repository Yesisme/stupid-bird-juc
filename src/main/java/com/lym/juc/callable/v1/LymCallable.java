package com.lym.juc.callable.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class LymCallable implements Callable<Map> {
    @Override
    public Map call() throws InterruptedException {
        HashMap<String,String> map = new HashMap<>();
        map.put("name","lymCallable");
        Thread.sleep(5000L);
        return map;
    }

    public static void main(String[] args) throws Exception{
        FutureTask task = new FutureTask(new LymCallable());
        new Thread(task).start();
        System.out.println("main不阻塞!");
        Object o = task.get();
        System.out.println(o);
    }
}
