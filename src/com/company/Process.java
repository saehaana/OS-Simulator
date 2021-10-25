package com.company;

public class Process{
    private String Process;
    private int Cycle;
    private String State;

    public void setProcess(String newProcess){
        this.Process = newProcess;
    }
    public String getProcess(){
        return Process;
    }
    /**Program will read program file/template as input
     * Input will generate processes of random cycle length for each operation
     * Operations include:
     *      CALCULATE - run process in run state for cycle(s) (simulates CPU resource usage)
     *      I/O       - put process in wait state for cycle(s)**/
    public void setCycle(int newCycle){
        this.Cycle = newCycle;
    }
    public int getCycle(){
        return Cycle;
    }
}