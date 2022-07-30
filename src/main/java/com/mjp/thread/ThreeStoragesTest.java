package com.mjp.thread;

public class ThreeStoragesTest {

    public static void main(String[] args) {

        ThreeStorages threeStorages = new ThreeStorages();

        boolean b = threeStorages.addStorage("3333");
        System.out.println("flag is " + b);

        System.out.println("size is " + threeStorages.getStorageSize());
    }


}