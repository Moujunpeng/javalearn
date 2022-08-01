package com.mjp.jvm;


public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigsize = new byte[2 * _1MB];

    public static void main(String[] args) throws InterruptedException {

        ReferenceCountingGC obj1 = new ReferenceCountingGC();
        ReferenceCountingGC obj2 = new ReferenceCountingGC();

        obj1.instance = obj2;
        obj2.instance = obj1;

        obj1 = null;
        obj2 = null;

        System.gc();

        //Thread.sleep(100000000);
    }

}