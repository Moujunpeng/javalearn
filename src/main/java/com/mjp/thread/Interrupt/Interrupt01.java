package com.mjp.thread.Interrupt;

public class Interrupt01 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {

            boolean flag = false;

            while (true){

                // 程序中加入中断响应的代码，如果没有中断响应的代码，则即使调用
                // Thread.currentThread().interrupt(); 线程也不会退出
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("响应中断");
                    return;
                }

                try {
                    if(!flag){
                        Thread.sleep(3000);
                    }else{
                        System.out.println("0000000");
                    }
                } catch (InterruptedException e) {
                    System.out.println("Java技术栈线程休眠被中断，程序退出。");
                    flag = true;
                    Thread.currentThread().interrupt();
                }
            }
        });

        thread.start();
        Thread.sleep(10000000);
        thread.interrupt();
    }

}
