package com.mjp.jvm;

public class JavaVMStackSOF1 {

    private int stackLength = 1;

    public void stackLeak(){

        long unuse1,unuse2,unuse3,unuse4,unuse5,
        unuse6,unuse7,unuse8,unuse9,unuse10,unuse11,unuse12,unuse13,unuse14,unuse15,
                unuse16,unuse17,unuse18,unuse19,unuse20,unuse21,unuse22,unuse23,unuse24,unuse25,
                unuse26,unuse27,unuse28,unuse29,unuse30,unuse31,unuse32,unuse33,unuse34,unuse35,
                unuse36,unuse37,unuse38,unuse39,unuse40,unuse41,unuse42,unuse43,unuse44,unuse45;

        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF1 javaVMStackSOF = new JavaVMStackSOF1();
        try{
            javaVMStackSOF.stackLeak();
        }catch (Throwable ex){
            System.out.println("stack length is " + javaVMStackSOF.stackLength);
            throw ex;
        }
    }

}