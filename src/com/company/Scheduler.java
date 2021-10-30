/**Uses Round Robin scheduling algorithm:
 * Will be given time quantum of q = 4
 * First task will execute for one time quantum,
 * First task then preempted and next task in queue will execute for one time quantum; repeat
 * If task completes execution before time quantum finishes, then move onto next task in queue and give one time quantum**/

/**Ready queue - queue of all processes waiting to be scheduled on core/CPU; does not have to be in main memory
 * Job queue   - list of all processes that reside on mass storage and await main memory allocation; new process goes in job queue **/

package com.company;

public class Scheduler{

    public void roundRobin(){

    }


}