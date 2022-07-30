package com.mjp.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchoronizedIntegerTest extends Thread{

    public SynchoronizedIntegerTest(SynchronizedInteger synInt) {
        this.synInt = synInt;
    }

    private SynchronizedInteger synInt;

    @Override
    public void run() {
        System.out.println("input value is " + synInt.getValue());
        //synInt.setValue(111);
    }

    public static void main(String[] args) throws InterruptedException {

        int input = 100;
        SynchronizedInteger synchronizedInteger = new SynchronizedInteger(input);

        Thread.yield();
        Thread.sleep(1);



        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i = 0;i < 10;i++){
            executorService.submit(new SynchoronizedIntegerTest(synchronizedInteger));
        }


        //new SynchoronizedIntegerTest(synchronizedInteger).start();

//        for(int i = 0;i < 1000;i++){
//            Thread.yield();
//        }
        synchronizedInteger.setValue(1000);
        System.out.println("main input value is " + synchronizedInteger.getValue());

    }


}