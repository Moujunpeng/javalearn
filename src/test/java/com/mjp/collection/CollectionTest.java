package com.mjp.collection;

import com.mjp.dto.CalcuInfo;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

public class CollectionTest {

    @Test
    public void testProcessors(){

        System.out.println("process is "  + Runtime.getRuntime().availableProcessors());

    }

    @Test
    public void testHashCode(){

        String a = "000000";

        int i = a.hashCode();

        int hashcode = i ^ (i >>> 16);

        System.out.println("output hashcode is " + hashcode);

        int position = (128 - 1) & hashcode;

        System.out.println("output position is " + position);

        System.out.println("Residual is " + (hashcode%128));

        System.out.println(a.hashCode());

    }

    @Test
    public void testHashCode1(){

        CalcuInfo cal = new CalcuInfo(1, "000");
        System.out.println("hash code is " + cal.hashCode());

    }

    @Test
    public void testConCurrentHashMap(){

        ConcurrentHashMap<Integer, String> hashMap = new ConcurrentHashMap<>();


    }

}