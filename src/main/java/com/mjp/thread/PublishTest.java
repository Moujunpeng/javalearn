package com.mjp.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PublishTest {

    public Holder holder;

    public void initialize() throws InterruptedException {
        holder = new Holder(40);
    }

    public static void main(String[] args) throws InterruptedException {
        PublishTest publishTest = new PublishTest();
        new Thread(()->{
            try {
                Thread.sleep(10);
                publishTest.initialize();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0;i < 1000;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(publishTest.holder);
                }
            });
        }


    }

}