package com.figo.concurrency.simple;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Created by 50245 on 2018/6/6.
 */
public class JoinTest extends Thread {

    @Override
    public void run() {
        Piao piao = new Piao();
        Thread t1 = new Thread(piao, "窗口1");
        try {
            t1.start();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Piao piao2 = new Piao();
        Thread t2 = new Thread(piao2, "窗口2");
        t2.start();
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
//        JoinTest joinTest =new JoinTest();
//        joinTest.start();


        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());


        singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.shutdown();
    }
}



