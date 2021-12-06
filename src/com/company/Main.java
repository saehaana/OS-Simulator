//Ausawin Saehaan
package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Process class objects
        Process process = new Process();

        //PCB class objects
        PCB pcbCalculator = new PCB();
        PCB pcbGame = new PCB();
        PCB pcbMicrosoftWord = new PCB();
        PCB pcbStorage = new PCB();

        //Scheduler class objects
        Scheduler scheduler = new Scheduler();

        //Other variables and objects
        String currLine;
        int menuSelection;
        Threader thread1 = new Threader("Thread-1");
        Threader thread2 = new Threader("Thread-2");

        ArrayList<Integer> runTime = new ArrayList<>();
        ArrayList<Integer> waitTime = new ArrayList<>();
        ArrayList<Integer> newQueue = new ArrayList<>();
        ArrayList<Integer> readyQueue = new ArrayList<>();
        ArrayList<String> stateQueue = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        List<Integer> calculatorPPidList = new ArrayList<>();
        List<Integer> gamePPidList = new ArrayList<>();
        List<Integer> microsoftwordPPidList = new ArrayList<>();
        List<Integer> storagePPidList = new ArrayList<>();

        List<String> calculatorStateList = new ArrayList<>();
        List<String> gameStateList = new ArrayList<>();
        List<String> microsoftwordStateList = new ArrayList<>();
        List<String> storageStateList = new ArrayList<>();

        ArrayList<Integer> childRunTime = new ArrayList<>();
        ArrayList<Integer> childWaitTime = new ArrayList<>();

        //Template files
        BufferedReader brCalculatorLoad = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Calculator.txt"));
        BufferedReader brCalculatorRun = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Calculator.txt"));
        BufferedReader brGameLoad = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Game.txt"));
        BufferedReader brGameRun = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Game.txt"));
        BufferedReader brMicrosoftWordLoad = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\MicrosoftWord.txt"));
        BufferedReader brMicrosoftWordRun = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\MicrosoftWord.txt"));
        BufferedReader brStorageLoad = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Storage.txt"));
        BufferedReader brStorageRun = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Storage.txt"));

        System.out.println("****************************************");
        System.out.println("Welcome to Ausawin's OS simulator!");
        System.out.println("****************************************");
        System.out.println("Choose any of the options below by pressing the corresponding number");
        System.out.println("Once you've entered an option, type 'return' to go back to main menu");
        System.out.println("1: Load Applications");
        System.out.println("2: Process state status");
        System.out.println("3: Run Scheduler");
        System.out.println("0: Quit");
        while(scanner.hasNextInt()){
            menuSelection = scanner.nextInt();
            switch (menuSelection) {
                case 0 -> {
                    System.out.println("Goodbye!");
                    return; //breaks while loop
                }
                case 1 -> {
                    System.out.println("You chose option 1");
                    System.out.println("Load different programs from the list below by typing the program name");
                    System.out.println("To run a program type 'run *program* (ignore ' and * characters)");
                    System.out.println("To minimize a program type 'min *program* (ignore ' and * characters)");
                    System.out.println("To close a program type 'close *program* (ignore ' and * characters)");
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Programs: ");
                    System.out.println("Calculator," + " Game," + " Microsoft Word," + " Storage");
                    while(scanner.hasNextLine()){
                        String processName = scanner.nextLine();

                        //application process states set to new
                        //processes given pid
                        //processes take memory
                        //different operations with varying cycles given based on program user selects
                        if(processName.equalsIgnoreCase("Calculator")){
                            System.out.println("How many processes would you like to create?");
                            int numProcesses = scanner.nextInt();
                            process.setNumProcesses(numProcesses);
                            System.out.println(numProcesses + " processes created");
                            for(int i=1;i<=numProcesses;i++){
                                System.out.println("Process " + i + " given ppid..");
                                pcbCalculator.setPPid(getRandomNumber(1,500));
                                pcbCalculator.setState("NEW");
                                System.out.println(pcbCalculator.getPPid());
                                calculatorPPidList.add(pcbCalculator.getPPid());
                            }
                            System.out.println("------------------------------");
                            System.out.println("Operations for given processes are: ");
                            while((currLine = brCalculatorLoad.readLine()) != null){
                                if(currLine.equals("-50")){
                                    int memory = Integer.parseInt(currLine);
                                    if((Process.memorySize + numProcesses * memory) > 0){
                                        Process.memorySize = Process.memorySize + numProcesses * memory;
                                        pcbCalculator.setState("READY");
                                        calculatorStateList.add(pcbCalculator.getState());
                                    }
                                    if((Process.memorySize - memory) < memory){
                                        pcbCalculator.setState("WAITING");
                                    }
                                    System.out.println(numProcesses * memory + " MB allocated to " + processName + " process");
                                    System.out.println(Process.memorySize + " MB left for other processes");
                                }
                                if(currLine.equals("FORK")){
                                    pcbCalculator.setPid(pcbCalculator.getPPid());
                                    runTime.addAll(childRunTime);
                                    waitTime.addAll(childWaitTime);
                                    System.out.println("\nProcess forked, parent process " + pcbCalculator.getPPid() + " attributes given to child process " + pcbCalculator.getPid() + "\n");
                                }
                                if(currLine.equals("CALCULATE")){
                                    thread1.start();
                                    process.setCycle(getRandomNumber(5,100));
                                    runTime.add(process.getCycle());
                                    childRunTime.add(process.getCycle());
                                    System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                }
                                if(currLine.equals("I/O")){
                                    thread2.start();
                                    process.setCycle(getRandomNumber(11, 82));
                                    waitTime.add(process.getCycle());
                                    childWaitTime.add(process.getCycle());
                                    System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                }
                            }
                        System.out.println("Return to menu by typing 'return' or load another application by typing its name");
                        }
                        if (processName.equalsIgnoreCase("Game")) {
                            System.out.println("How many processes would you like to create?");
                            int numProcesses = scanner.nextInt();
                            process.setNumProcesses(numProcesses);
                            System.out.println(numProcesses + " processes created");
                            for(int i=1;i<=numProcesses;i++){
                                System.out.println("Process " + i + " given pid..");
                                pcbGame.setPPid(getRandomNumber(1,500));
                                pcbGame.setState("NEW");
                                System.out.println(pcbGame.getPPid());
                                gamePPidList.add(pcbGame.getPPid());
                            }
                            System.out.println("Operations for given processes are: ");
                            System.out.println("------------------------------");
                            while ((currLine = brGameLoad.readLine()) != null) {
                                if(currLine.equals("-100")){
                                    int memory = Integer.parseInt(currLine);
                                    if((Process.memorySize + (numProcesses*memory)) > 0){
                                        Process.memorySize = Process.memorySize + (numProcesses*memory);
                                        pcbGame.setState("READY");
                                        gameStateList.add(pcbGame.getState());
                                    }
                                    if((Process.memorySize - memory) < memory){
                                        pcbGame.setState("WAITING");
                                    }
                                    System.out.println(numProcesses * memory + " MB allocated to " + processName + " process");
                                    System.out.println(Process.memorySize + " MB left for other processes");
                                }
                                if (currLine.equals("CALCULATE")) {
                                    thread1.start();
                                    process.setCycle(getRandomNumber(5, 100));
                                    runTime.add(process.getCycle());
                                    System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                }
                                if (currLine.equals("I/O")) {
                                    thread2.start();
                                    process.setCycle(getRandomNumber(11, 82));
                                    waitTime.add(process.getCycle());
                                    System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                }
                            }
                            System.out.println("Return to menu by typing 'return' or load another application by typing its name");
                        }
                        if (processName.equalsIgnoreCase("Microsoft Word")) {
                            System.out.println("How many processes would you like to create?");
                            int numProcesses = scanner.nextInt();
                            process.setNumProcesses(numProcesses);
                            System.out.println(numProcesses + " processes created");
                            for(int i=1;i<=numProcesses;i++){
                                System.out.println("Process " + i + " given pid..");
                                pcbMicrosoftWord.setPPid(getRandomNumber(1,100));
                                pcbMicrosoftWord.setState("NEW");
                                System.out.println(pcbMicrosoftWord.getPPid());
                                microsoftwordPPidList.add(pcbMicrosoftWord.getPPid());
                            }
                            System.out.println("------------------------------");
                            while ((currLine = brMicrosoftWordLoad.readLine()) != null) {
                                if(currLine.equals("-30")){
                                    int memory = Integer.parseInt(currLine);
                                    if((Process.memorySize + numProcesses * memory) > 0){
                                        Process.memorySize = Process.memorySize + numProcesses * memory;
                                        pcbMicrosoftWord.setState("READY");
                                        microsoftwordStateList.add(pcbMicrosoftWord.getState());
                                    }
                                    if((Process.memorySize - memory) < memory){
                                        pcbMicrosoftWord.setState("WAITING");
                                    }
                                    System.out.println(numProcesses * memory + " MB allocated to " + processName + " process");
                                    System.out.println(Process.memorySize + " MB left for other processes");
                                }
                                if (currLine.equals("CALCULATE")) {
                                    thread1.start();
                                    process.setCycle(getRandomNumber(5, 100));
                                    runTime.add(process.getCycle());
                                    System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                }
                                if (currLine.equals("I/O")) {
                                    thread2.start();
                                    process.setCycle(getRandomNumber(11, 82));
                                    waitTime.add(process.getCycle());
                                    System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                }
                            }
                            System.out.println("Return to menu by typing 'return' or load another application by typing its name");
                        }
                        if (processName.equalsIgnoreCase("Storage")) {
                            System.out.println("How many processes would you like to create?");
                            int numProcesses = scanner.nextInt();
                            process.setNumProcesses(numProcesses);
                            System.out.println(numProcesses + " processes created");
                            for(int i=1;i<=numProcesses;i++){
                                System.out.println("Process " + i + " given pid..");
                                pcbStorage.setPid(getRandomNumber(1,500));
                                pcbStorage.setState("NEW");
                                System.out.println(pcbStorage.getPPid());
                                storagePPidList.add(pcbStorage.getPPid());
                            }
                            System.out.println("------------------------------");
                            while ((currLine = brStorageLoad.readLine()) != null) {
                                if(currLine.equals("-30")){
                                    int memory = Integer.parseInt(currLine);
                                    if((Process.memorySize + numProcesses * memory) > 0){
                                        Process.memorySize = Process.memorySize + numProcesses * memory;
                                        pcbStorage.setState("READY");
                                        storageStateList.add(pcbStorage.getState());
                                    }
                                    if((Process.memorySize - memory) < memory){
                                        pcbStorage.setState("WAITING");
                                    }
                                    System.out.println(numProcesses * memory + " MB allocated to " + processName + " process");
                                    System.out.println(Process.memorySize + " MB left for other processes");
                                }
                                if(currLine.equals("FORK")){
                                    pcbCalculator.setPid(pcbCalculator.getPPid());
                                    runTime.addAll(childRunTime);
                                    waitTime.addAll(childWaitTime);
                                    System.out.println("\nProcess forked, parent process " + pcbCalculator.getPPid() + " attributes given to child process " + pcbCalculator.getPid() + "\n");
                                }
                                if (currLine.equals("CALCULATE")) {
                                    thread1.start();
                                    process.setCycle(getRandomNumber(5, 100));
                                    runTime.add(process.getCycle());
                                    childRunTime.add(process.getCycle());
                                    System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                }
                                if (currLine.equals("I/O")) {
                                    thread2.start();
                                    process.setCycle(getRandomNumber(11, 82));
                                    waitTime.add(process.getCycle());
                                    childWaitTime.add(process.getCycle());
                                    System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                }
                            }
                            System.out.println("Return to menu by typing 'return' or load another application by typing its name");
                        }

                        // run program
                        // executes calculate and i/o instructions of an application's process
                        if(processName.equalsIgnoreCase("run calculator")){
                            System.out.println("Running calculator operations...");
                            while ((currLine = brCalculatorRun.readLine()) != null) {
                                if (currLine.equals("CALCULATE")) {
                                    pcbCalculator.setState("RUNNING");
                                    System.out.println("Current " + currLine + " queue " + runTime);
                                    for (int i = 0; i < runTime.size(); i++) {
                                        System.out.println("Running operation " + currLine + " " + runTime.get(i));

                                        process.runCycle(runTime.get(i));
                                        Process.resource--;

                                        System.out.println(currLine + " done");
                                        System.out.println("Removing operation " + currLine + " " + runTime.get(i));
                                        runTime.remove(i);

                                        //if random number generated is less than 30, cause IO interrupt and make processes wait
                                        if (randomIO(11, 82) < 20) {
                                            System.out.println("\nRandom I/O event occurred");
                                            System.out.println("Waiting...");
                                            process.setCycle(5);
                                            process.waitCycle(process.getCycle());
                                            //Thread.sleep(50);
                                            System.out.println("done\n");
                                        }
                                    }
                                }
                                if (currLine.equals("I/O")) {
                                    pcbCalculator.setState("WAITING");
                                    System.out.println("Current " + currLine + " queue " + waitTime);
                                    for (int i = 0; i < waitTime.size(); i++) {
                                        System.out.println("Running operation " + currLine + " " + waitTime.get(i));
                                        System.out.println("Waiting...");

                                        process.waitCycle(waitTime.get(i));
                                        Process.resource++;

                                        System.out.println(currLine + " done");
                                        System.out.println("Removing operation " + currLine + " " + waitTime.get(i));
                                        waitTime.remove(i);
                                    }
                                }
                                if (currLine.equals("CRIT_START")) {
                                    try {
                                        for (int i = 0; i < calculatorPPidList.size(); i++) {
                                            System.out.println("PPid " + calculatorPPidList.get(i) + " waiting for lock..");
                                            CriticalSection.semaphore.acquire();
                                            System.out.println("PPid " + calculatorPPidList.get(i) + " acquired lock");
                                            Process.resource++;
                                            CriticalSection.semaphore.release();
                                        }
                                    } catch (InterruptedException e) {
                                        System.out.println(e);
                                    }
                                    CriticalSection.semaphore.release();
                                }
                                if (currLine.equals("CRIT_END")) {
                                    for (int i = 0; i < calculatorPPidList.size(); i++) {
                                        System.out.println("PPid " + calculatorPPidList.get(i) + " released lock");
                                        Process.resource++;
                                    }
                                    CriticalSection.semaphore.release();
                                }
                                if (currLine.equals("+50")) {
                                    int memory = Integer.parseInt(currLine);
                                    if ((Process.memorySize + process.getNumProcesses() * memory) <= 1024) {
                                        Process.memorySize = Process.memorySize + process.getNumProcesses() * memory;
                                        System.out.println(process.getNumProcesses() * memory + " MB reallocated to total memory");
                                        System.out.println(Process.memorySize + " MB left for other processes");
                                    }
                                }
                            }
                        }
                        if(processName.equalsIgnoreCase("run game")){
                            pcbGame.setState("RUNNING");
                            System.out.println("Running game operations...");
                            while((currLine = brGameRun.readLine()) != null){
                                if(currLine.equals("CALCULATE")){
                                    pcbGame.setState("RUNNING");
                                    System.out.println("Current " + currLine + " queue " + runTime);
                                    for(int i=0;i<runTime.size();i++){
                                        System.out.println("Running operation " + currLine + " " + runTime.get(i));

                                        process.runCycle(runTime.get(i));
                                        Process.resource--;

                                        System.out.println(currLine + " done");
                                        System.out.println("Removing operation " + currLine + " " + runTime.get(i));
                                        runTime.remove(i);

                                        //if random number generated is less than 30, cause IO interrupt and make processes wait
                                        if(randomIO(11,82) < 20){
                                            System.out.println("\nRandom I/O event occurred");
                                            System.out.println("Waiting...");
                                            process.setCycle(5);
                                            process.waitCycle(process.getCycle());
                                            System.out.println("done\n");
                                        }
                                    }
                                }
                                if(currLine.equals("I/O")){
                                    pcbGame.setState("WAITING");
                                    System.out.println("Current " + currLine + " queue " + waitTime);
                                    for(int i=0;i<waitTime.size();i++){
                                        System.out.println("Running operation " + currLine + " " + waitTime.get(i));
                                        System.out.println("Waiting...");

                                        process.waitCycle(waitTime.get(i));
                                        Process.resource++;

                                        System.out.println(currLine + " done");
                                        System.out.println("Removing operation " + currLine + " " + waitTime.get(i));
                                        waitTime.remove(i);
                                    }
                                }
                                if(currLine.equals("CRIT_START")){
                                    try{
                                        for(int i=0;i<gamePPidList.size();i++){
                                            System.out.println("PPid " + gamePPidList.get(i) + " waiting for lock..");
                                            CriticalSection.semaphore.acquire();
                                            System.out.println("PPid " + gamePPidList.get(i) + " acquired lock");
                                            Process.resource++;
                                            CriticalSection.semaphore.release();
                                        }
                                    }catch(InterruptedException e){
                                        System.out.println(e);
                                    }
                                    CriticalSection.semaphore.release();
                                }
                                if(currLine.equals("CRIT_END")){
                                    for(int i=0;i<gamePPidList.size();i++) {
                                        System.out.println("PPid " + gamePPidList.get(i) + " released lock");
                                        Process.resource++;
                                    }
                                    CriticalSection.semaphore.release();
                                }
                                if (currLine.equals("+100")) {
                                    int memory = Integer.parseInt(currLine);
                                    if ((Process.memorySize + process.getNumProcesses() * memory) <= 1024) {
                                        Process.memorySize = Process.memorySize + process.getNumProcesses() * memory;
                                        System.out.println(process.getNumProcesses() * memory + " MB reallocated to total memory");
                                        System.out.println(Process.memorySize + " MB left for other processes");
                                    }
                                }
                            }
                        }
                        if (processName.equalsIgnoreCase("run microsoft word")) {
                            pcbMicrosoftWord.setState("RUNNING");
                            System.out.println("Running microsoft word operations...");
                            while((currLine = brMicrosoftWordRun.readLine()) != null){
                                if(currLine.equals("CALCULATE")){
                                    pcbMicrosoftWord.setState("RUNNING");
                                    System.out.println("Current " + currLine + " queue " + runTime);
                                    for(int i=0;i<runTime.size();i++){
                                        System.out.println("Running operation " + currLine + " " + runTime.get(i));

                                        process.runCycle(runTime.get(i));
                                        Process.resource--;

                                        System.out.println(currLine + " done");
                                        System.out.println("Removing operation " + currLine + " " + runTime.get(i));
                                        runTime.remove(i);

                                        //if random number generated is less than 30, cause IO interrupt and make processes wait
                                        if(randomIO(11,82) < 20){
                                            System.out.println("\nRandom I/O event occurred\n");
                                            System.out.println("Waiting...");
                                            process.setCycle(5);
                                            process.waitCycle(process.getCycle());
                                            System.out.println("done\n");
                                        }
                                    }
                                }
                                if(currLine.equals("I/O")){
                                    pcbMicrosoftWord.setState("WAITING");
                                    System.out.println("Current " + currLine + " queue " + waitTime);
                                    for(int i=0;i<waitTime.size();i++){
                                        System.out.println("Running operation " + currLine + " " + waitTime.get(i));
                                        System.out.println("Waiting...");

                                        process.waitCycle(waitTime.get(i));
                                        Process.resource++;

                                        System.out.println(currLine + " done");
                                        System.out.println("Removing operation " + currLine + " " + waitTime.get(i));
                                        waitTime.remove(i);
                                    }
                                }
                                if(currLine.equals("CRIT_START")){
                                    try{
                                        for(int i=0;i<microsoftwordPPidList.size();i++){
                                            System.out.println("PPid " + microsoftwordPPidList.get(i) + " waiting for lock..");
                                            CriticalSection.semaphore.acquire();
                                            System.out.println("PPid " + microsoftwordPPidList.get(i) + " acquired lock");
                                            Process.resource++;
                                        }
                                    }catch(InterruptedException e){
                                        System.out.println(e);
                                    }
                                    CriticalSection.semaphore.release();
                                }
                                if(currLine.equals("CRIT_END")){
                                    for(int i=0;i<microsoftwordPPidList.size();i++) {
                                        System.out.println("PPid " + microsoftwordPPidList.get(i) + " released lock");
                                        Process.resource++;
                                    }
                                    CriticalSection.semaphore.release();
                                }
                                if (currLine.equals("+30")) {
                                    int memory = Integer.parseInt(currLine);
                                    if ((Process.memorySize + process.getNumProcesses() * memory) <= 1024) {
                                        Process.memorySize = Process.memorySize + process.getNumProcesses() * memory;
                                        System.out.println(process.getNumProcesses() * memory + " MB reallocated to total memory");
                                        System.out.println(Process.memorySize + " MB left for other processes");
                                    }
                                }
                            }
                        }
                        if (processName.equalsIgnoreCase("run storage")) {
                            pcbStorage.setState("RUNNING");
                            System.out.println("Running storage operations...");
                            while((currLine = brStorageRun.readLine()) != null){
                                if(currLine.equals("CALCULATE")){
                                    pcbStorage.setState("RUNNING");
                                    System.out.println("Current " + currLine + " queue " + runTime);
                                    for(int i=0;i<runTime.size();i++){
                                        System.out.println("Running operation " + currLine + " " + runTime.get(i));

                                        process.runCycle(runTime.get(i));
                                        Process.resource--;

                                        System.out.println(currLine + " done");
                                        System.out.println("Removing operation " + currLine + " " + runTime.get(i));
                                        runTime.remove(i);

                                        //if random number generated is less than 30, cause IO interrupt and make processes wait
                                        if(randomIO(11,82) < 20){
                                            System.out.println("\nRandom I/O event occurred\n");
                                            System.out.println("Waiting...");
                                            process.setCycle(5);
                                            process.waitCycle(process.getCycle());
                                            System.out.println("done\n");
                                        }
                                    }
                                }
                                if(currLine.equals("I/O")){
                                    pcbStorage.setState("WAITING");
                                    System.out.println("Current " + currLine + " queue " + waitTime);
                                    for(int i=0;i<waitTime.size();i++){
                                        System.out.println("Running operation " + currLine + " " + waitTime.get(i));
                                        System.out.println("Waiting...");

                                        process.waitCycle(waitTime.get(i));
                                        Process.resource++;

                                        System.out.println(currLine + " done");
                                        System.out.println("Removing operation " + currLine + " " + waitTime.get(i));
                                        waitTime.remove(i);
                                    }
                                }
                                if(currLine.equals("CRIT_START")){
                                    try{
                                        for(int i=0;i<storagePPidList.size();i++){
                                            System.out.println("PPid " + storagePPidList.get(i) + " waiting for lock..");
                                            CriticalSection.semaphore.acquire();
                                            System.out.println("PPid " + storagePPidList.get(i) + " acquired lock");
                                            Process.resource++;
                                        }
                                    }catch(InterruptedException e){
                                        System.out.println(e);
                                    }
                                    CriticalSection.semaphore.release();
                                }
                                if(currLine.equals("CRIT_END")){
                                    for(int i=0;i<storagePPidList.size();i++) {
                                        System.out.println("PPid " + storagePPidList.get(i) + " released lock");
                                        Process.resource++;
                                    }
                                    CriticalSection.semaphore.release();
                                }
                                if (currLine.equals("+30")) {
                                    int memory = Integer.parseInt(currLine);
                                    if ((Process.memorySize + process.getNumProcesses() * memory) <= 1024) {
                                        Process.memorySize = Process.memorySize + process.getNumProcesses() * memory;
                                        System.out.println(process.getNumProcesses() * memory + " MB reallocated to total memory");
                                        System.out.println(Process.memorySize + " MB left for other processes");
                                    }
                                }
                            }
                        }

                        // close program
                        // terminates and/or exits application's process

                        /**if (processName.equalsIgnoreCase("close calculator")) {
                            pcbCalculator.setState(null);
                            System.out.println("Calculator closed");
                        }
                        if (processName.equalsIgnoreCase("close game")) {
                            pcbGame.setState(null);
                            System.out.println("Game closed");
                        }
                        if (processName.equalsIgnoreCase("close microsoft word")) {
                            pcbMicrosoftWord.setState(null);
                            System.out.println("Microsoft word closed");
                        }
                        if (processName.equalsIgnoreCase("close storage")) {
                            pcbStorage.setState(null);
                            System.out.println("Storage closed");
                        }
                        **/
                        if (processName.equalsIgnoreCase("return")) {
                            System.out.println("Returning to main menu...\n");
                            System.out.println("Choose any of the options below by pressing the corresponding number");
                            System.out.println("1: Load applications");
                            System.out.println("2: Check process states");
                            System.out.println("3: Run Scheduler");
                            System.out.println("0: Quit");
                            break;
                        }
                    }
                }

                case 2 -> {
                    System.out.println("You chose option 2");
                    System.out.println("Which application's process state would you like to check?");
                    while (scanner.hasNextLine()) {
                        String processName = scanner.nextLine();
                        if(processName.equalsIgnoreCase("Calculator")) {
                            if(!(calculatorPPidList.isEmpty())) {
                                for(int i=0;i<calculatorPPidList.size();i++){
                                    System.out.println("Process state of ppid " + calculatorPPidList.get(i).toString() + " is " + calculatorStateList.get(i));
                                }
                            System.out.println("Enter another application or return to menu: ");
                            }else{
                                System.out.println("Application's processes not found");
                                System.out.println("Enter loaded application or go back to option 1 in main menu");
                            }
                        }
                        if (processName.equalsIgnoreCase("Game")) {
                            if(!(gamePPidList.isEmpty())){
                                for(int i=0;i<gamePPidList.size();i++) {
                                    System.out.println("Process state of ppid " + gamePPidList.get(i).toString() + " is " + gameStateList.get(i));
                                }
                            System.out.println("Enter another application or return to menu: ");
                            }else{
                                System.out.println("Application's processes not found");
                                System.out.println("Enter loaded application or go back to option 1 in main menu");
                            }
                        }
                        if (processName.equalsIgnoreCase("Microsoft Word")) {
                            if(!(microsoftwordPPidList.isEmpty())){
                                for(int i=0;i<microsoftwordPPidList.size();i++){
                                    System.out.println("Process state of ppid " + microsoftwordPPidList.get(i).toString() + " is " + microsoftwordStateList.get(i));
                                }
                            System.out.println("Enter another application or return to menu: ");
                            }else{
                                System.out.println("Application's processes not found");
                                System.out.println("Enter loaded application or go back to option 1 in main menu");
                            }
                        }
                        if (processName.equalsIgnoreCase("Storage")) {
                            if(!(storagePPidList.isEmpty())){
                                for(int i=0;i<storagePPidList.size();i++){
                                    System.out.println("Process state of ppid " + storagePPidList.get(i).toString() + " is " + storageStateList.get(i));
                                }
                            System.out.println("Enter another application or return to menu: ");
                            }else{
                                System.out.println("Application's processes not found");
                                System.out.println("Enter loaded application or go back to option 1 in main menu");
                            }
                        }
                        if (processName.equalsIgnoreCase("return")) {
                            System.out.println("Returning to main menu...\n");
                            System.out.println("Choose any of the options below by pressing the corresponding number");
                            System.out.println("1: Applications");
                            System.out.println("2: Check process states");
                            System.out.println("3: Run Scheduler");
                            System.out.println("0: Quit");
                            break;
                        }
                    }
                }
                case 3 -> {

                    System.out.println("You chose option 3");
                    readyQueue.addAll(calculatorPPidList);
                    readyQueue.addAll(gamePPidList);
                    readyQueue.addAll(microsoftwordPPidList);
                    readyQueue.addAll(storagePPidList);

                    stateQueue.addAll(calculatorStateList);
                    stateQueue.addAll(gameStateList);
                    stateQueue.addAll(microsoftwordStateList);
                    stateQueue.addAll(storageStateList);

                    System.out.println("Current ready queue consists of ppids.. " + readyQueue);
                    System.out.println("Current ready queue consists of burst times.. " + runTime);
                    System.out.println("Current wait queue consists of wait times.. " + waitTime);
                    System.out.println("Running scheduler...");

                    for(int i=0;i<stateQueue.size()-1;i++){
                        if(!(calculatorStateList.isEmpty())){
                            calculatorStateList.set(i, "RUNNING");
                        }
                        if(!(gameStateList.isEmpty())){
                            gameStateList.set(i, "RUNNING");
                        }
                        if(!(microsoftwordStateList.isEmpty())){
                            microsoftwordStateList.set(i, "RUNNING");
                        }
                        if(!(storageStateList.isEmpty())){
                            storageStateList.set(i, "RUNNING");
                        }
                    }

                    System.out.println("PPID " + " Burst time " + " Waiting time\n");
                    Scheduler.findAvgTime(readyQueue,readyQueue.size(),runTime,scheduler.timeQuantum);

                    for(int i=0;i<runTime.size()-1;i++){
                        process.runCycle(runTime.get(i));
                        Process.resource--;
                    }
                    runTime.clear();
                    waitTime.clear();
                    readyQueue.clear();
                    stateQueue.clear();

                    pcbCalculator.setState(null);
                    pcbGame.setState(null);
                    pcbMicrosoftWord.setState(null);
                    pcbStorage.setState(null);

                    //pcbCalculator.setPid((Integer) null);
                    //pcbGame.setPid((Integer) null);
                    //pcbMicrosoftWord.setPid((Integer) null);
                    //pcbStorage.setPid((Integer) null);

                    System.out.println("\nReturning to main menu...\n");
                    System.out.println("Choose any of the options below by pressing the corresponding number");
                    System.out.println("1: Open applications");
                    System.out.println("2: Check process states");
                    System.out.println("3: Run Scheduler");
                    System.out.println("0: Quit");
                    }
                }
            }
    }
    /**Generates random number within a certain range; to be used as a representation of cycles for processes
     * min: lower bound of random number range
     * max: upper bound of random number range**/
    public static int getRandomNumber(int min, int max){
        return (int) (Math.random() * (max-min) + min);
    }
    /**Chance for I/O event to occur if the random number generated is within a certain range**/
    public static int randomIO(int min, int max){
        return  (int) (Math.random() * (max-min) + min);
    }

}

