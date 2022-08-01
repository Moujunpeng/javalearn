package com.mjp.thread;

public class Interrupt0000 {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            while (true){
//                Thread.yield();
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("Java技术栈线程被中断，程序退出。");
                    return;
                }
            }
        });

        thread.start();
        thread.interrupt();

    }

}
