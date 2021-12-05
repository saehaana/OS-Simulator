package com.company;

import java.util.ArrayList;

public class ThreadTest extends Thread{
    private Thread t;
    private final String threadName;
    Process process = new Process();
    ArrayList<Integer> runTime = new ArrayList<>();
    ArrayList<Integer> waitTime = new ArrayList<>();

    ThreadTest(String name){
        threadName = name;
        System.out.println("Creating " + threadName);
    }
    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
    public void run(){
        System.out.println("Running " + threadName);
        try{
            process.setCycle(getRandomNumber(5,100));
            Thread.sleep(25);

            } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    public static int getRandomNumber(int min, int max){
        return (int) (Math.random() * (max-min) + min);
    }
}
