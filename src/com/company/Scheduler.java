/**Round Robin scheduling algorithm:
 * Will be given time quantum of q
 * First task will execute for one time quantum,
 * First task then preempted and next task in queue will execute for one time quantum; repeat
 * If task completes execution before time quantum finishes, then move onto next task in queue and give one time quantum
 * rule of thumb -- 80% of CPU bursts should be smaller than the time quantum**/

/**Ready queue - queue of all processes waiting to be scheduled on core/CPU; does not have to be in main memory
 * Job queue   - list of all processes that reside on mass storage and await main memory allocation; new process goes in job queue **/

package com.company;

import java.util.ArrayList;
import java.util.*;

public class Scheduler{
    public int timeQuantum = 70;

    public ArrayList<Integer> readyQueue = new ArrayList<>();
    public ArrayList<Integer> waitQueue = new ArrayList<>();
    public ArrayList<Integer> executeQueue = new ArrayList<>();

    //Shortest Job First (SJF)
    public void sort(ArrayList<Integer> queue){
        Collections.sort(queue, new Comparator<Integer>() {
            @Override
            public int compare(Integer pid1, Integer pid2) {
                return Integer.compare(pid1, pid2);
            }
        });
    }

    public static void findWaitTime(ArrayList<Integer> readyQueue, int length, ArrayList<Integer> burstTime, int[] waitTime, int timeQuantum){
        int[] remainingBurstTime = new int[length]; //stores remaining burst times; equal to remaining process length from arraylist
        for(int i=0;i<length;i++){
            remainingBurstTime[i] = burstTime.get(i);
        }
        int time = 0; //current time

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