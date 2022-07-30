package com.mjp.jvm;

import java.util.ArrayList;

public class HeapTest extends Thread{

    @Override
    public void run() {
        ArrayList<OOMObject> list = new ArrayList<>();

        while (true){

            list.add(new OOMObject());
        }
    }

    static class OOMObject{

    }

    public static void main(String[] args) {
//
//        ArrayList<OOMObject> list = new ArrayList<>();
//
//        while (true){
//
//            list.add(new OOMObject());
//        }
        HeapTest heapTest = new HeapTest();
        heapTest.start();

    }

}