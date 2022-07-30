package com.mjp.thread;

import javax.swing.table.TableRowSorter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SemaphoreTest extends Thread{

    private int i;

    BoundedHashSet<Integer> integerBoundedHashSet = null;

    public SemaphoreTest(BoundedHashSet<Integer> integerBoundedHashSet,int i) {
        this.integerBoundedHashSet = integerBoundedHashSet;
        this.i = i;
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        BoundedHashSet<Integer> integerBoundedHashSet = new BoundedHashSet<Integer>(10);

        for(int i = 0;i < 100;i++){
            executorService.submit(new SemaphoreTest(integerBoundedHashSet,i));
        }

        for(int i = 0;i<100;i++){
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    integerBoundedHashSet.remove(finalI);
                }
            });
        }

    }

    @Override
    public void run() {
        System.out.println("current thread name is " + Thread.currentThread().getName() + " " + i);
        try {
            System.out.println("current size is " + integerBoundedHashSet.getSet().size());
            integerBoundedHashSet.add(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
