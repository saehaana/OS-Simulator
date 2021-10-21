//Ausawin Saehaan
package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Process();
    }
    /**Program will read program file/template as input
     * Input will generate processes of random cycle length for each operation
     * Operations include CALCULATE, I/O**/
    static void Process() throws IOException {
        String currLine;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Template1.txt"));
        while((currLine = br.readLine()) != null) {
            System.out.println(currLine);
            if(currLine.equals("CALCULATE")){
                System.out.println("yes");

            }
            if(currLine.equals("I/O")){
                System.out.println("no");
            }
        }

    }
    /** Will retrieve and store information about and from other OS components**/
    public class PCB{
        private int pid;

        public void setPid(){
            this.pid = pid;
        }
        public int getPid(){
            return pid;
        }
    }
    public class Crit{
        /**Will contain at least one critical section and critical section resolving scheme
         * Information about each process to be stored in Process Control Block (PCB)**/
    }

    /**Uses Round Robin scheduling algorithm:
     * Will be given time quantum of q = 4
     * First task will execute for one time quantum,
     * First task then preempted and next task in queue will execute for one time quantum; repeat
     * If task completes execution before time quantum finishes, then move onto next task in queue and give one time quantum**/
    public class Scheduler{

    }
}

