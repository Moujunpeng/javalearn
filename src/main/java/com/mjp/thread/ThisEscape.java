package com.mjp.thread;

import java.util.EventListener;

public class ThisEscape {

    EventSource eventSource = null;
    private int a = 0;

    public ThisEscape(EventSource eventSource) {

        Thread thread = new Thread(() -> {
            //System.out.println("00000000000000000000");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int b = this.a;
            System.out.println("a is " + b);
        });

        thread.start();

        a = 1000;

        this.eventSource = eventSource;
    }

    public static void main(String[] args) throws InterruptedException {

        EventSource eventSource = new EventSource();
        ThisEscape thisEscape = new ThisEscape(eventSource);

        Thread.sleep(5000);

    }
}