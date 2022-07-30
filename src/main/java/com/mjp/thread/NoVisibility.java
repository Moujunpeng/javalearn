package com.mjp.thread;

public class NoVisibility {

    private static boolean ready;

    private static int number;

    private static class ReaderThread extends Thread{

        @Override
        public void run() {
            while (!ready){
                Thread.yield();
            }
            System.out.println(number);
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        new ReaderThread().start();
        ready = true;
        number = 42;

        Thread.sleep(10000000L);
    }

}