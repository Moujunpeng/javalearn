package com.mjp.threadpoolexecutor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {

    static ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {

        for(int i = 0;i < 1000;i++){
           executor.submit(()->{
               System.out.println(Thread.currentThread().getName() + "-> execute");
           });
        }

    }

}
