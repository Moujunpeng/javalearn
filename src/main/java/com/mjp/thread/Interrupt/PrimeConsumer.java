package com.mjp.thread.Interrupt;

import java.math.BigInteger;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PrimeConsumer {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<BigInteger> bigIntegers = new LinkedBlockingQueue<BigInteger>(100);

        PrimeProcucer primeProcucer = new PrimeProcucer(bigIntegers);
        primeProcucer.start();

        for(int i = 0;i < 10;i++){
            System.out.println("consume integer is " + bigIntegers.take());
        }

        Thread.sleep(1000);
        primeProcucer.cancel();

        System.out.println("after queue size is " + bigIntegers.size());
        while (bigIntegers.size() > 0){
            System.out.println(bigIntegers.take());
            System.out.println("local queue size is " + bigIntegers.size());
        }
    }

}