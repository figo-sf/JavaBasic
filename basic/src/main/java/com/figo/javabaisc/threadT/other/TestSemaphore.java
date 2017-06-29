package com.figo.javabaisc.threadT.other;

import java.util.concurrent.Semaphore;

/**
 * ������JAVA��߽̳�-�ź���(Semaphore)��ʹ�á�<br>
 * �����ߺ������ߵ����ӣ����Ĺ���
 *
 * @author ������(java2000.net,laozizhu.com)
 */
public class TestSemaphore {

    public static void main(String[] args) {
        // �����߳�
        for (int i = 0; i <= 3; i++) {
            // ������
            new Thread(new Producer()).start();
            // ������
            new Thread(new Consumer()).start();
        }
    }

    // �ֿ�
    static Warehouse buffer = new Warehouse();

    // �����ߣ���������
    static class Producer implements Runnable {
        static int num = 1;

        public void run() {
            int n = num++;
            while (true) {
                try {
                    buffer.put(n);
                    System.out.println("����" + n);
                    // �ٶȽϿ졣��Ϣ10����
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // �����ߣ��������
    static class Consumer implements Runnable {

        public void run() {
            while (true) {
                try {
                    System.out.println("����" + buffer.take());
                    // �ٶȽ�������Ϣ1000����
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * �ֿ�
     *
     * @author ������(laozizhu.com)
     */
    static class Warehouse {
        // ������
        final Semaphore notFull = new Semaphore(10);
        // �ǿ���
        final Semaphore notEmpty = new Semaphore(0);
        // ������
        final Semaphore mutex = new Semaphore(1);

        // �������
        final Object[] items = new Object[10];
        int putptr, takeptr, count;

        /**
         * ����Ʒ����ֿ�.<br>
         *
         * @param x
         * @throws InterruptedException
         */
        public void put(Object x) throws InterruptedException {
            // ��֤����
            notFull.acquire();
            // ��֤����ͻ
            mutex.acquire();
            try {
                // ���ӿ��
                items[putptr] = x;
                if (++putptr == items.length)
                    putptr = 0;
                ++count;
            } finally {
                // �˳�������
                mutex.release();
                // ���ӷǿ��ź����������ȡ��Ʒ
                notEmpty.release();
            }
        }

        /**
         * �Ӳֿ��ȡ��Ʒ
         *
         * @return
         * @throws InterruptedException
         */
        public Object take() throws InterruptedException {
            // ��֤�ǿ�
            notEmpty.acquire();
            // ������
            mutex.acquire();
            try {
                // ���ٿ��
                Object x = items[takeptr];
                if (++takeptr == items.length)
                    takeptr = 0;
                --count;
                return x;
            } finally {
                // �˳�������
                mutex.release();
                // ���ӷ������ź��������������Ʒ
                notFull.release();
            }
        }
    }
}  
