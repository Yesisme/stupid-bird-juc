package com.lym.juc.callable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class LymCallable implements Callable<Map> {
    @Override
    public Map call() throws Exception {
        HashMap<String,String> map = new HashMap<>();
        map.put("name","lymCallable");
        return map;
    }

    public static void main(String[] args) throws Exception{
        FutureTask task = new FutureTask(new LymCallable());
        new Thread(task).start();
        Object o = task.get();
        System.out.println(o);
    }
}
