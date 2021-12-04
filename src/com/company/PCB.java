/**Will retrieve and store information about and from other OS components
 * Information about each process to be stored in Process Control Block (PCB):
 * process state
 * program counter
 * CPU registers
 * CPU scheduling info
 * memory-management info
 * accounting info
 * I/O status info**/

package com.company;

import java.util.ArrayList;

public class PCB{
    private static int pid;
    private static int ppid;
    private static int numChildren;
    private String State;

    ArrayList<Process> numChildrenList = new ArrayList<Process>(0);
    private Process parent;

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

    public int setPid(int newPid){
        this.pid = newPid;
        return newPid;
    }
    public int getPid(){
        return pid;
    }

    public int setPPid(int newPPid){
        this.ppid = newPPid;
        return newPPid;
    }

    public int getPPid(){
        return ppid;
    }
    /**public void setParent(PCB parent) {
        this.parent = parent;
    }
    public Process getParent(){
        return parent;
    }

    public void addChild(PCB child)
    {
        numChildrenList.add(child);
    }

    public void setNumChildren(int Children){
        this.numChildren = Children;
        for(int i=0;i<Children;i++){
            numChildrenList.add(i);
        }
    }
    public int getNumChildren(){
        return numChildren;
    }

    //used for cascading termination - if parent terminates, then all children terminate
    public void terminate(){
        if(getNumChildren() == 0){
            this.setState("TERMINATED");
        }else{
            for(int i=0;i<getNumChildren();i++){
                getNumChildren().get(i).terminate();
            }
        }
    }
    public void removeChild(int i){
        getNumChildren().get(i).exit();
    }**/
}

