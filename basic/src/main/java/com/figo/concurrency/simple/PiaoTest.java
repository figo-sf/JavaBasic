package com.figo.concurrency.simple;

import java.util.concurrent.*;

/**
 * Created by 50245 on 2018/6/6.
 */
public class PiaoTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Piao piao= new Piao();
//        Thread t1 =new Thread(piao,"窗口1");
//        Thread t2 =new Thread(piao,"窗口2");
//        t1.start();
//        t2.start();
        ExecutorService executor = Executors.newCachedThreadPool();
        PiaoCall task = new PiaoCall();
        Future<Integer> future = executor.submit(task);
        //System.out.println(future.get());
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        Thread thread = new Thread(futureTask,"窗口2");
        thread.start();
        System.out.println(future.isDone());
        executor.shutdown();
        System.out.println(future.get());
        System.out.println(future.isDone());
    }
}
