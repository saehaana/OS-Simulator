//Ausawin Saehaan
package com.company;
import java.util.Scanner;
import java.io.File;
public class Main {
    public static void main(String[] args) {
        Process();
    }
    static void Process(){
        // Scanner scan = new Scanner(System.in);
        // System.out.println("How many processes would you like to create?: ");
        // String process = scan.nextLine();
        // System.out.println(": " + process);
        File file = new File("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Template1.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

    }
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
    }
    public class Scheduler{
    }
    public class CPU{
    }
}

