package com.mjp.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentModificationTesst {

    public static void main(String[] args) {

        Collection<Integer> list = Collections.synchronizedCollection(new ArrayList<Integer>());

        for(int i =0;i< 1000000;i++){
            list.add(i);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i = 0;i < 100;i++){

            int finalI = i;
            executorService.submit(()->{
                System.out.println("add param is " + finalI);
                list.add(finalI);
            });

        }

        synchronized (list){
            for(int i : list){
                System.out.println("input param is " + i);
            }

        }

    }
}