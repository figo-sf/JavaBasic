package com.figo.concurrency.simple;

import java.util.concurrent.Callable;

/**
 * Created by 50245 on 2018/6/6.
 */
public class PiaoCall implements Callable<Integer> {
    private int totalPiao =100;
    private Object ob = new Object();
    @Override
    public Integer call() throws Exception {
        while (totalPiao>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (ob){
                if(totalPiao>0){
                    System.out.println(Thread.currentThread().getName()+"卖出的第"+(100-totalPiao+1)+"票");
                }
                totalPiao--;
            }

        }

        return totalPiao;
    }

}
