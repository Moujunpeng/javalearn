package com.mjp.thread;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class BoundedHashSet<Integer> {

   private final Set<Integer> set;

   private final Semaphore sem;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<Integer>());
        this.sem = new Semaphore(10);
    }

    public Set<Integer> getSet() {
        return set;
    }

    public Semaphore getSem() {
        return sem;
    }

    public boolean add(Integer o) throws InterruptedException {

        System.out.println("sem availablePermits is " + sem.availablePermits());

        System.out.println("Semaphore add is " + o);
        sem.acquire();
        boolean wasAdded = false;
        try{
            wasAdded = set.add(o);
            return wasAdded;
        }finally {
            if(!wasAdded){
                sem.release();
            }
        }

    }

    public boolean remove(Integer o){

        System.out.println("Semaphore remove is " + o);

        boolean remove = set.remove(o);
        if(remove) {
            sem.release();
        }

//        sem.availablePermits();
        return remove;

    }

}