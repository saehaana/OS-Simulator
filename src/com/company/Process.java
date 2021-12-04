package com.company;

import java.io.IOException;
import java.util.*;

public class Process extends Thread{
    private int Cycle;
    private int Process;
    public static int resource = 0;
    private PCB current;

    /**Value of memorySize to be used as comparison against memory requirements of new processes
     * If memorySize - (used memory) is more than new job memory requirement, job can enter READY state (queue)
     * Else process remains in NEW queue (if spawned) or WAITING queue (if trying to re-enter READY state)**/
    public static int memorySize = 1024;

    /**Program will read program file/template as input
     * Input will generate processes of random cycle length for each operation
     * Operations include:
     *      CALCULATE - run process in run state for cycle(s) (simulates CPU resource usage)
     *      I/O       - put process in wait state for cycle(s)
     *      FORK      - create child process according to selected parent-child management scheme**/
    public void setCycle(int newCycle){
        this.Cycle = newCycle;
    }
    public int getCycle(){
        return Cycle;
    }

    public void runCycle(Integer cycleTime) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;
        cycleTime = (int) (long) elapsedTime;

        while(cycleTime < getCycle()){
            cycleTime = Math.toIntExact((new Date()).getTime() - startTime);
        }
    }
    public void waitCycle(Integer cycleTime) {
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;
        cycleTime = (int) (long) elapsedTime;

        while(cycleTime < getCycle()){
            cycleTime = Math.toIntExact((new Date()).getTime() - startTime);
        }
    }

    public void setNumProcesses(int numProcess){
        this.Process = numProcess;
    }
    public int getNumProcesses(){
        return Process;
    }

    //creates new process (child process), which runs concurrently with process that makes fork() call (parent process)
    /**public void fork(PCB child, boolean wait) throws IOException{
        child.setParent(current);
        current.addChild(child);
    }**/

    public void run(){
        try{
            System.out.println("Thread " + Thread.currentThread().getId() + " is now running...");
        }catch(Exception e){
            System.out.println("Exception is caught");
        }
    }

}