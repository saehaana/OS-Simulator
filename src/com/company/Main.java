//Ausawin Saehaan
package com.company;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Process process = new Process();


        String currLine;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Template1.txt"));
        while((currLine = br.readLine()) != null) {
            if(currLine.equals("CALCULATE")){
                process.setCPU(getRandomNumber(5,100));
                System.out.println(currLine + " given " + process.getCPU() + " cycles");
            }
            if(currLine.equals("I/O")){
                process.setCPU(getRandomNumber(11,82));
                System.out.println(currLine + " given " + process.getCPU() + " cycles");
            }
        }
    }
    /**Generates random number within a certain range; to be used as a representation of cycles for processes
     * min: lower bound of random number range
     * max: upper bound of random number range**/
    public static int getRandomNumber(int min, int max){
        return (int) (Math.random() * (max-min) + min);
    }
}

