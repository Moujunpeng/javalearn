package com.mjp.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 通过开一个守护线程的方式，来不断接收外层for循环中往阻塞队列中添加的任务
 */

public class CalInterfaceDemon {


    private CalculationInfo calculation;

    private LinkedBlockingQueue<CalculationInfo> linkedBlockingQueue = null;

    private static ExecutorService executorService = Executors.newFixedThreadPool(50);

    public CalInterfaceDemon(LinkedBlockingQueue<CalculationInfo> linkedBlockingQueue) {
        this.linkedBlockingQueue = linkedBlockingQueue;

        calculationThread calculationThread = new calculationThread();
        calculationThread.setDaemon(true);
        calculationThread.start();
    }


    class calculationThread extends Thread{

        @Override
        public void run() {
            while (true){
                try {
                    CalculationInfo take = linkedBlockingQueue.take();
                    executorService.submit(take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {


        LinkedBlockingQueue<CalculationInfo> linkedBlockingQueue = new LinkedBlockingQueue<>();

        CalInterfaceDemon calculationInterface = new CalInterfaceDemon(linkedBlockingQueue);

        for(int i = 0;i < 1000;i++){
                CalculationInfo thread = new CalculationInfo(i,1);
                linkedBlockingQueue.add(thread);
        }


    }

}
