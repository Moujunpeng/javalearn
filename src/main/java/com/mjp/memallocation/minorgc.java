package com.mjp.memallocation;

public class minorgc {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {

        byte[] mem1,mem2,mem3,mem4;
        // mem1的内存是2MB
        mem1 = new byte[2 * _1MB];
        mem2 = new byte[2 * _1MB];
        mem3 = new byte[2 * _1MB];
        mem4 = new byte[4 * _1MB];
    }

}