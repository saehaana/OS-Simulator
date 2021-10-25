//Ausawin Saehaan
package com.company;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader brCalculator = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Calculator.txt"));
        BufferedReader brGame = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Game.txt"));
        BufferedReader brMicrosoftWord = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\MicrosoftWord.txt"));
        BufferedReader brStorage = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Storage.txt"));

        Process process = new Process();
        String currLine;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select up to 2 programs you would like to run from list below:");
        System.out.println("Calculator," + " Game," + " Microsoft Word," + " Storage");
        System.out.println("Programs: ");
        String processName = scanner.nextLine();

        if(processName.equalsIgnoreCase("Calculator")){
            while((currLine = brCalculator.readLine()) != null) {
                if(currLine.equals("CALCULATE")){
                    process.setState("NEW");
                    process.setCycle(getRandomNumber(5,100));
                    System.out.println(process.getState() + " " + currLine + " given " + process.getCycle() + " cycles");
                }
                if(currLine.equals("I/O")){
                    process.setState("NEW");
                    process.setCycle(getRandomNumber(11,82));
                    System.out.println(process.getState() + " " + currLine + " given " + process.getCycle() + " cycles");
                }
            }
        }
        if(processName.equalsIgnoreCase("Game")){
            while((currLine = brGame.readLine()) != null) {
                if(currLine.equals("CALCULATE")){
                    process.setState("NEW");
                    process.setCycle(getRandomNumber(5,100));
                    System.out.println(process.getState() + " " + currLine + " given " + process.getCycle() + " cycles");
                }
                if(currLine.equals("I/O")){
                    process.setState("NEW");
                    process.setCycle(getRandomNumber(11,82));
                    System.out.println(process.getState() + " " + currLine + " given " + process.getCycle() + " cycles");
                }
            }
        }
        if(processName.equalsIgnoreCase("Microsoft Word")){
            while((currLine = brMicrosoftWord.readLine()) != null) {
                if(currLine.equals("CALCULATE")){
                    process.setState("NEW");
                    process.setCycle(getRandomNumber(5,100));
                    System.out.println(process.getState() + " " + currLine + " given " + process.getCycle() + " cycles");
                }
                if(currLine.equals("I/O")){
                    process.setState("NEW");
                    process.setCycle(getRandomNumber(11,82));
                    System.out.println(process.getState() + " " + currLine + " given " + process.getCycle() + " cycles");
                }
            }
        }
        if(processName.equalsIgnoreCase("Storage")){
            while((currLine = brStorage.readLine()) != null) {
                if(currLine.equals("CALCULATE")){
                    process.setState("NEW");
                    process.setCycle(getRandomNumber(5,100));
                    System.out.println(process.getState() + " " + currLine + " given " + process.getCycle() + " cycles");
                }
                if(currLine.equals("I/O")){
                    process.setState("NEW");
                    process.setCycle(getRandomNumber(11,82));
                    System.out.println(process.getState() + " " + currLine + " given " + process.getCycle() + " cycles");
                }
            }
        }





        /**while((currLine = brCalculator.readLine()) != null) {
            if(currLine.equals("CALCULATE")){
                process.setState("NEW");
                process.setCycle(getRandomNumber(5,100));
                System.out.println(process.getState() + " " + currLine + " given " + process.getCycle() + " cycles");
            }
            if(currLine.equals("I/O")){
                process.setState("NEW");
                process.setCycle(getRandomNumber(11,82));
                System.out.println(process.getState() + " " + currLine + " given " + process.getCycle() + " cycles");
            }
        }**/


    }
    /**Generates random number within a certain range; to be used as a representation of cycles for processes
     * min: lower bound of random number range
     * max: upper bound of random number range**/
    public static int getRandomNumber(int min, int max){
        return (int) (Math.random() * (max-min) + min);
    }
}

