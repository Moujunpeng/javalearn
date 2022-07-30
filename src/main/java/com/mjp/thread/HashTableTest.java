package com.mjp.thread;

import java.util.Hashtable;

public class HashTableTest {

    public static void main(String[] args) {

        Hashtable<String, String> hashtable = new Hashtable<>();

        for(int i = 0;i < 10;i++){
            int finalI = i;
            new Thread(()->{

                hashtable.put(""+ finalI,""+ finalI);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("size is " + hashtable.size());
            }).start();
        }



    }


}