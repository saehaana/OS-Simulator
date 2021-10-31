/**Uses Round Robin scheduling algorithm:
 * Will be given time quantum of q = 4
 * First task will execute for one time quantum,
 * First task then preempted and next task in queue will execute for one time quantum; repeat
 * If task completes execution before time quantum finishes, then move onto next task in queue and give one time quantum**/

/**Ready queue - queue of all processes waiting to be scheduled on core/CPU; does not have to be in main memory
 * Job queue   - list of all processes that reside on mass storage and await main memory allocation; new process goes in job queue **/

package com.company;

import java.util.ArrayList;

public class Scheduler{
    public int timeQuantum = 10;

    public static void findWaitTime(ArrayList<Integer> readyQueue, int length, ArrayList<Integer> burstTime, int[] waitTime, int timeQuantum){
        int time = 0; //current time

        int[] remainingBurstTime = new int[length]; //stores remaining burst times; equal to remaining process length from arraylist
        for(int i=0;i<length;i++){
            remainingBurstTime[i] = burstTime.get(i);
        }

        while(true){ //loop through processes until all processes not done
            boolean done = true;
            for(int i=0;i<length;i++){
                if(remainingBurstTime[i]>0){ //if process time greater than 0, proceed
                    done = false; //process still pending
                    if(remainingBurstTime[i] > timeQuantum){
                        time += timeQuantum; //time that has been processed
                        remainingBurstTime[i] -= timeQuantum;
                    }else{
                        time = time +  remainingBurstTime[i];
                        waitTime[i] = time - burstTime.get(i); //current time - time used by process
                        remainingBurstTime[i] = 0; //remaining burst time = 0 when process fully executed
                    }
                }
            }
            if(done){
                break;
            }
        }
    }
    public static void findAvgTime(ArrayList <Integer> readyQueue, int length, ArrayList<Integer> burstTime, int timeQuantum){
        int[] waitTime = new int[length];
        int totalWaitTime = 0;
        findWaitTime(readyQueue, length, burstTime, waitTime, timeQuantum);
        for(int i=0;i<length;i++){
            totalWaitTime = totalWaitTime + waitTime[i];
            System.out.println(" " + (readyQueue.get(i)) + "\t\t" + burstTime.get(i) +"\t " +
                    waitTime[i] +"\t\t ");
            System.out.println("Average waiting time = " + ((float)totalWaitTime / (float)length));
            System.out.println("------------------------------");
        }
    }
}