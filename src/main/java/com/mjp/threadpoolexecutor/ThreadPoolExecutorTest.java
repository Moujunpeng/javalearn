package com.mjp.threadpoolexecutor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

    static ThreadPoolExecutor executor= new ThreadPoolExecutor(0,5,10,TimeUnit.SECONDS,new LinkedBlockingQueue<>(15));

    public static void main(String[] args) {

        for(int i = 0;i< 200;i++){
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

    }


}
