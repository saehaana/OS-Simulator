package com.company;

import java.util.*;

public class Process{
    private int Cycle;
    public static int resource = 0;

    /**Program will read program file/template as input
     * Input will generate processes of random cycle length for each operation
     * Operations include:
     *      CALCULATE - run process in run state for cycle(s) (simulates CPU resource usage)
     *      I/O       - put process in wait state for cycle(s)**/
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
}