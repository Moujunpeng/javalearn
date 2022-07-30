package com.mjp.thread;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UnsafeStatesTest extends Thread{

    private UnsafeStates unsafeStates;

    public UnsafeStatesTest(UnsafeStates unsafeStates) {
        this.unsafeStates = unsafeStates;
    }

    @Override
    public void run() {
        super.run();
    }

    public static void main(String[] args) throws InterruptedException {

        UnsafeStates unsafeStates = new UnsafeStates();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for(int i = 0;i < 1000;i++){
            int finalI = i;
            executor.submit(()->{
                String[] states = unsafeStates.getStates();
                //states =  new String[] {"000",Thread.currentThread().getName().toString()};
                states[0] = String.valueOf(finalI);
                System.out.println(Thread.currentThread().getName() + " : " + Arrays.toString(unsafeStates.getStates()));
            });
        }

        Thread.sleep(5000);

        System.out.println(Thread.currentThread().getName() + " : " + Arrays.toString(unsafeStates.getStates()));
    }

}
