package com.mjp.jvm1;

public class JavaVMStackOOMByThread {

    private int numsThread = 0;

    public void stackLeakByThread(){

        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){

                    }
                }
            });
            System.out.println("thread num is " + numsThread++);
            thread.start();
        }
    }


    public static void main(String[] args) {
        JavaVMStackOOMByThread javaVMStackOOM = new JavaVMStackOOMByThread();
        javaVMStackOOM.stackLeakByThread();
    }


}