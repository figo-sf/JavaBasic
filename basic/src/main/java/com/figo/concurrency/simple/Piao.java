package com.figo.concurrency.simple;

/**
 * Created by 50245 on 2018/6/6.
 */
public class Piao implements Runnable {
    private int totalPiao =100;
    private Object ob = new Object();
    @Override
    public void run() {
        while (totalPiao>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sellPiao();
        }

    }

    public void sellPiao(){
        synchronized (ob){
            if(totalPiao>0){
                System.out.println(Thread.currentThread().getName()+"卖出的第"+(100-totalPiao+1)+"票");
                totalPiao--;
            }
        }

    }
}
