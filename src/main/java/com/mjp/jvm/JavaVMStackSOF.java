package com.mjp.jvm;

public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try{
            javaVMStackSOF.stackLeak();
        }catch (Throwable ex){
            System.out.println("stack length is " + javaVMStackSOF.stackLength);
            throw ex;
        }
    }


}