package com.figo.javabaisc.threadT.other;

import java.util.Date;

class TimePrinter2 implements Runnable {
    int pauseTime;
    String name;

    public TimePrinter2(int x, String y) {
        pauseTime = x;
        name = y;
    }



    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(name + ":"
                        + new Date(System.currentTimeMillis()));
                Thread.sleep(pauseTime);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    static public void main(String args[]) {
        Thread t1 = new Thread(new TimePrinter2(1000, "Fast Guy"));
        t1.start();
        Thread t2 = new Thread(new TimePrinter2(3000, "Slow Guy"));
        t2.start();
    }
}
