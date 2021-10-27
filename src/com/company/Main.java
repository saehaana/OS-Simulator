//Ausawin Saehaan
package com.company;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //class objects
        Scanner scanner = new Scanner(System.in);
        Process process = new Process();
        PCB pcb = new PCB();
        CriticalSection cs = new CriticalSection();
        Scheduler scheduler = new Scheduler();

        //PCB class objects
        PCB pcbCalculator = new PCB();
        PCB pcbGame = new PCB();
        PCB pcbMicrosoftWord = new PCB();
        PCB pcbStorage = new PCB();

        //variables
        String currLine;
        int menuSelection;

        //template files
        BufferedReader brCalculator = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Calculator.txt"));
        BufferedReader brGame = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Game.txt"));
        BufferedReader brMicrosoftWord = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\MicrosoftWord.txt"));
        BufferedReader brStorage = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Storage.txt"));

        System.out.println("****************************************");
        System.out.println("Welcome to Ausawin's OS simulator!");
        System.out.println("****************************************");
        System.out.println("Choose any of the options below by pressing the corresponding number");
        System.out.println("Once you've entered an option, type 'return' to go back to main menu");
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
                    System.out.println("Calculator," + " Game," + " Microsoft Word," + " Storage");
                    System.out.println("Programs: ");
                    while(scanner.hasNextLine()){
                            String processName = scanner.nextLine();
                            //different operations with cycles given based on program user selects
                            if(processName.equalsIgnoreCase("Calculator")){
                                pcbCalculator.setState("NEW");
                                while((currLine = brCalculator.readLine()) != null) {
                                    if(currLine.equals("CALCULATE")){
                                        process.setCycle(getRandomNumber(5,100));
                                        System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                    }
                                    if(currLine.equals("I/O")){
                                        process.setCycle(getRandomNumber(11,82));
                                        System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                    }
                                }
                            }
                            if(processName.equalsIgnoreCase("Game")){
                                pcbGame.setState("NEW");
                                while((currLine = brGame.readLine()) != null) {
                                    if(currLine.equals("CALCULATE")){
                                        process.setCycle(getRandomNumber(5,100));
                                        System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                    }
                                    if(currLine.equals("I/O")){
                                        process.setCycle(getRandomNumber(11,82));
                                        System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                    }
                                }
                            }
                            if(processName.equalsIgnoreCase("Microsoft Word")){
                                pcbMicrosoftWord .setState("NEW");
                                while((currLine = brMicrosoftWord.readLine()) != null) {
                                    if(currLine.equals("CALCULATE")){
                                        process.setCycle(getRandomNumber(5,100));
                                        System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                    }
                                    if(currLine.equals("I/O")){
                                        process.setCycle(getRandomNumber(11,82));
                                        System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                    }
                                }
                            }
                            if(processName.equalsIgnoreCase("Storage")){
                                pcbStorage.setState("NEW");
                                while((currLine = brStorage.readLine()) != null) {
                                    if(currLine.equals("CALCULATE")){
                                        process.setCycle(getRandomNumber(5,100));
                                        System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                    }
                                    if(currLine.equals("I/O")){
                                        process.setCycle(getRandomNumber(11,82));
                                        System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                    }
                                }
                            }
                            if(processName.equalsIgnoreCase("return")){
                                System.out.println("Returning to main menu...\n");
                                System.out.println("Choose any of the options below by pressing the corresponding number");
                                System.out.println("1: Open applications");
                                System.out.println("2: Check process states");
                                System.out.println("3: Check PCB components");
                                System.out.println("4: Check something else");
                                System.out.println("0: Quit");
                                break;
                            }
                            //if((!(processName.equalsIgnoreCase("calculator")) || (!(processName.equalsIgnoreCase("game")))) || (!(processName.equalsIgnoreCase("microsoft word"))) || (!(processName.equalsIgnoreCase("storage"))) || (!(processName.equalsIgnoreCase("return")))) {
                            //    System.out.println("Unknown option, try again");
                            //}
                        }
                    break;
                case 2:
                    System.out.println("You chose option 2");
                    System.out.println("Which application's process state would you like to check?");
                    while(scanner.hasNextLine()) {
                        String processName = scanner.nextLine();

                        if(processName.equalsIgnoreCase("Calculator")){
                            System.out.println("Process state of " + processName + " is: " + pcbCalculator.getState());
                        }
                        else if(processName.equalsIgnoreCase("Game")){
                            System.out.println("Process state of " + processName + " is: " + pcbGame.getState());
                        }
                        else if(processName.equalsIgnoreCase("Microsoft Word")){
                            System.out.println("Process state of " + processName + " is: " + pcbMicrosoftWord.getState());
                        }
                        else if(processName.equalsIgnoreCase("Storage")){
                            System.out.println("Process state of " + processName + " is: " + pcbStorage.getState());
                        }
                        else if(processName.equalsIgnoreCase("return")) {
                            System.out.println("Returning to main menu...\n");
                            System.out.println("Choose any of the options below by pressing the corresponding number");
                            System.out.println("1: Open applications");
                            System.out.println("2: Check process states");
                            System.out.println("3: Check PCB components");
                            System.out.println("4: Check something else");
                            System.out.println("0: Quit");
                            break;
                        }
                        else{
                            System.out.println("Please enter one of the listed applications you would like to check their processes' state for...or check your spelling");
                        }
                    }
                    break;
                case 3:
                    System.out.println("You chose option 3");
                    System.out.println("Which PCB component would you like to check?");
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

