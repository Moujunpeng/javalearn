package com.mjp.thread;

public class SynchronizedInteger {

    public SynchronizedInteger(int value) {
        this.value = value;
    }

    private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}
