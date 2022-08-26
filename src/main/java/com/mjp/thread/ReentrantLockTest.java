package com.mjp.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {


    private static Lock lock = new ReentrantLock(true);

    private static ExecutorService executor = Executors.newFixedThreadPool(100);

    public static void main(String[] args) throws InterruptedException {

        for(int i = 0;i < 4;i++){
            executor.submit(new ThreadDemo(i));
        }

    }

    static class ThreadDemo implements Runnable{

        int id;

        public ThreadDemo(int id) {
            this.id = id;
        }

        @Override
        public void run() {

            for(int i = 0;i < 2;i++){
                System.out.println("线程 " + id + "拿锁");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                lock.lock();
                System.out.println("线程 " + id + "拿到锁");
            }

            for(int i = 0;i < 2;i ++){
                System.out.println("线程 " + id + "释放锁");
                lock.unlock();
            }

        }
    }

}