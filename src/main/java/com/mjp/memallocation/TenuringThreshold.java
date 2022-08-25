package com.mjp.memallocation;

public class TenuringThreshold {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {

        byte[] allo1,allo2,allo3;

        allo1 = new byte[(1024 * 1024) / 4];
        allo2 = new byte[(1024 * 1024) * 4];
        // 发生一次垃圾回收，eden区无法容纳
        allo3 = new byte[_1MB * 4];

//        // 发生一次垃圾回收，allo1 升级到survivor区中
//        allo3 = null;
//        allo3 = new byte[_1MB * 4];
    }

}