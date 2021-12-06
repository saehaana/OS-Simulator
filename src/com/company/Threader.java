package com.company;

public class Threader extends Thread{
    private Thread t;
    private final String threadName;

    Threader(String name){
        threadName = name;
        System.out.println("Creating " + threadName);
    }
    public void run(){
        System.out.println("Running " + threadName);
        try{
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
