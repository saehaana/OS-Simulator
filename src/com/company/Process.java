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
    /**Processes create from templates must also be given process states
     * States include:
     *      NEW   - program or process being created or loaded (but not in memory yet)
     *      READY - program loaded into memory and waiting to run on CPU
     *      RUN   - instructions being executed
     *      WAIT  - program waiting for event to occur
     *      EXIT  - program finished execution on CPU; release resources and leaves memory**/
    public void setState(String newState){
        this.State = newState;
    }
    public String getState(){
        return State;
    }
}