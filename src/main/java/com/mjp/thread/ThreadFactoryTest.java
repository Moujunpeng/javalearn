package com.mjp.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadFactoryTest {


    public static void main(String[] args) {

        //MyThreadFactory mypool = new MyThreadFactory("mypool");

        ThreadFactory guavaThreadFactory = new ThreadFactoryBuilder().setNameFormat("retryClient-pool-%d").build();

        Thread thread = guavaThreadFactory.newThread(()->{
            System.out.println("thread name is " + Thread.currentThread().getName());
            while (true){

            }
        });

        thread.start();

        ThreadPoolExecutor executor= new ThreadPoolExecutor(5,5,10, TimeUnit.SECONDS,new LinkedBlockingQueue<>(15),
                guavaThreadFactory);

        for(int i = 0;i< 100;i++){
            executor.submit(()->{
                System.out.println("current thread name is " + Thread.currentThread().getName());
            });
        }

    }

}