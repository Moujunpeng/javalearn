package com.mjp.jvm;

import java.util.HashSet;
import java.util.Set;

public class RuntimeConstantPoolOOM {


    public static void main(String[] args) {

        Set<String> set = new HashSet<String>();

        int i = 0;

        while (true){
            System.out.println("input i is " + i);
            set.add(String.valueOf(i++).intern());
        }

    }

}
