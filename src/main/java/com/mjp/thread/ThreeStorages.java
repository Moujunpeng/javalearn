package com.mjp.thread;

import java.util.HashSet;
import java.util.Set;

public class ThreeStorages {

    private final Set<String> storages = new HashSet<String>();

    public ThreeStorages() {

        storages.add("0000");
        storages.add("1111");
    }

    public int getStorageSize(){
        return storages.size();
    }

    public boolean isStorage(String name){
        return storages.contains(name);
    }

    public boolean addStorage(String name){
        return storages.add(name);
    }
}
