//Ausawin Saehaan
package com.company;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //objects and variables
        Scanner scanner = new Scanner(System.in);
        Process process = new Process();
        PCB pcb = new PCB();
        CriticalSection cs = new CriticalSection();
        Scheduler scheduler = new Scheduler();
        String currLine;
        int menuSelection;
        boolean loop = true;

        //template files
        BufferedReader brCalculator = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Calculator.txt"));
        BufferedReader brGame = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Game.txt"));
        BufferedReader brMicrosoftWord = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\MicrosoftWord.txt"));
        BufferedReader brStorage = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Storage.txt"));

        System.out.println("****************************************");
        System.out.println("Welcome to Ausawin's OS simulator!");
        System.out.println("****************************************");
        System.out.println("Choose any of the options below by pressing the corresponding number");
        System.out.println("Command Options: ");
        System.out.println("1: Open applications");
        System.out.println("2: Check process states");
        System.out.println("3: Check PCB components");
        System.out.println("4: Check something else");
        System.out.println("0: Quit");
        while(scanner.hasNextInt()){
            menuSelection = scanner.nextInt();
            switch(menuSelection){
                case 0:
                    System.out.println("Goodbye!");
                    return; //breaks while loop
                case 1:
                    System.out.println("You chose option 1");
                    System.out.println("Select up to 2 different programs you would like to run from list below:");
                    System.out.println("Type 'return' to return back to main menu");
                    System.out.println("Calculator," + " Game," + " Microsoft Word," + " Storage");
                    System.out.println("Programs: ");
                    while(scanner.hasNextLine()){
                            String processName = scanner.nextLine();
                            //different operations with cycles given based on program user selects
                            if(processName.equalsIgnoreCase("Calculator")){
                                while((currLine = brCalculator.readLine()) != null) {
                                    if(currLine.equals("CALCULATE")){
                                        pcb.setState("NEW");
                                        process.setCycle(getRandomNumber(5,100));
                                        System.out.println(pcb.getState() + " " + currLine + " given " + process.getCycle() + " cycles");
                                    }
                                    if(currLine.equals("I/O")){
                                        pcb.setState("NEW");
                                        process.setCycle(getRandomNumber(11,82));
                                        System.out.println(pcb.getState() + " " + currLine + " given " + process.getCycle() + " cycles");
                                    }
                                }
                            }
                            if(processName.equalsIgnoreCase("Game")){
                                while((currLine = brGame.readLine()) != null) {
                                    if(currLine.equals("CALCULATE")){
                                        pcb.setState("NEW");
                                        process.setCycle(getRandomNumber(5,100));
                                        System.out.println(pcb.getState() + " " + currLine + " given " + process.getCycle() + " cycles");
                                    }
                                    if(currLine.equals("I/O")){
                                        pcb.setState("NEW");
                                        process.setCycle(getRandomNumber(11,82));
                                        System.out.println(pcb.getState() + " " + currLine + " given " + process.getCycle() + " cycles");
                                    }
                                }
                            }
                            if(processName.equalsIgnoreCase("Microsoft Word")){
                                while((currLine = brMicrosoftWord.readLine()) != null) {
                                    if(currLine.equals("CALCULATE")){
                                        pcb.setState("NEW");
                                        process.setCycle(getRandomNumber(5,100));
                                        System.out.println(pcb.getState() + " " + currLine + " given " + process.getCycle() + " cycles");
                                    }
                                    if(currLine.equals("I/O")){
                                        pcb.setState("NEW");
                                        process.setCycle(getRandomNumber(11,82));
                                        System.out.println(pcb.getState() + " " + currLine + " given " + process.getCycle() + " cycles");
                                    }
                                }
                            }
                            if(processName.equalsIgnoreCase("Storage")){
                                while((currLine = brStorage.readLine()) != null) {
                                    if(currLine.equals("CALCULATE")){
                                        pcb.setState("NEW");
                                        process.setCycle(getRandomNumber(5,100));
                                        System.out.println(pcb.getState() + " " + currLine + " given " + process.getCycle() + " cycles");
                                    }
                                    if(currLine.equals("I/O")){
                                        pcb.setState("NEW");
                                        process.setCycle(getRandomNumber(11,82));
                                        System.out.println(pcb.getState() + " " + currLine + " given " + process.getCycle() + " cycles");
                                    }
                                }
                            }
                            if(processName.equalsIgnoreCase("return")){
                                System.out.println("Returning to main menu...\n");
                                System.out.println("Choose any of the options below by pressing the corresponding number");
                                System.out.println("Command Options: ");
                                System.out.println("1: Open applications");
                                System.out.println("2: Check process states");
                                System.out.println("3: Check PCB components");
                                System.out.println("4: Check something else");
                                System.out.println("0: Quit");
                                break;
                            }
                        }
                    break;
                case 2:
                    System.out.println("You chose option 2");
                    break;
                case 3:
                    System.out.println("You chose option 3");
                    break;
                case 4:
                    System.out.println("You chose option 4");
                    break;
                default:
                    System.out.println("No such choice");
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

