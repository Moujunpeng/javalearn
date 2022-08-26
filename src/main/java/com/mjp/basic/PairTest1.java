package com.mjp.basic;

public class PairTest1 {

    public static void main(String[] args) {

        String[] words = {"a","b","c","dc"};

        Pair<String> minmax = ArrayAlg.minmax(words);
        System.out.println("min is " + minmax.getFirst());
        System.out.println("max is " + minmax.getSecond());

        String[] words2 = {"a","b","c","d"};
        int middle = ArrayAlg.getMiddle(1,2,3,4,5);
        System.out.println("middle is " + middle);

        Pair<String> min = ArrayAlg.min(words2);
        System.out.println("min is " + min.getFirst() + "max is " + min.getSecond());

        String s = ArrayAlg.minbyArray(words2);
        System.out.println("last min is " + s);

        Integer[] inputInteger = {Integer.parseInt("1111"),Integer.parseInt("2"),Integer.parseInt("3")};

        Integer mininteger = ArrayAlg.minbyArray(inputInteger);
        System.out.println("min integer is " + mininteger);
    }

}

class ArrayAlg{

    public static Pair<String> minmax(String[] a){
        if(a == null || a.length == 0){
            return null;
        }

        String min = a[0];
        String max = a[0];

        for(int i = 0;i < a.length ;i++){

            if(min.compareTo(a[i]) > 0) min = a[i];
            if(max.compareTo(a[i]) < 0) max = a[i];

        }

        return new Pair<>(min,max);
    }

    /**
     * 在普通类中定义一个泛型方法
     * @param a
     * @param <T>
     * @return
     */
    public static <T> T getMiddle(T... a){
        return a[a.length/2];
    }

    /**
     * 求最小值 ，并且增加类型的限定
     * @param a
     * @param <T>
     * @return
     */
    public static <T extends Comparable> Pair<T> min(T[] a){

        if(a == null || a.length == 0){
            return null;
        }

        T smallest = a[0];
        for(int i = 0;i < a.length;i++){
            if(smallest.compareTo(a[i]) > 0) smallest = a[i];
        }

        return new Pair<>(smallest,smallest);
    }

    /**
     * 求最小值 ，并且增加类型的限定
     * @param a
     * @param <T>
     * @return
     */
    public static <T extends Comparable> T minbyArray(T[] a){

        if(a == null || a.length == 0){
            return null;
        }

        T smallest = a[0];
        for(int i = 0;i < a.length;i++){
            if(smallest.compareTo(a[i]) > 0) smallest = a[i];
        }

        return smallest;
    }


}