package com.mjp.thread;

public class CalculationInfo extends Thread{


    private int input;

    private int output;

    public CalculationInfo(int input, int output) {
        this.input = input;
        this.output = output;
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }


    @Override
    public void run() {
        output = input * input;
        System.out.println(Thread.currentThread().getName() + " output is " + output);
    }

}
