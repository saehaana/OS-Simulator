package com.company;

public class ThreadTest extends Thread{
    private Thread t;
    private final String threadName;

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
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        }catch(InterruptedException e){

        }
    }


}
