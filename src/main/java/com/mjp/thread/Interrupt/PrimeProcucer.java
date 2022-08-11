package com.mjp.thread.Interrupt;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class PrimeProcucer extends Thread{

    private final BlockingQueue<BigInteger> queue;

    public PrimeProcucer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted()){
                queue.put(p=p.nextProbablePrime());
                System.out.println("queue size is " + queue.size());
            }
        } catch (InterruptedException e) {
            return;
        }
    }

    public void cancel(){
        interrupt();
    }

}