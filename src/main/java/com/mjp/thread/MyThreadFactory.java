package com.mjp.thread;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }


    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r,poolName);
    }
}
