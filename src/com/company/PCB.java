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

public class PCB{
    private int pid;
    private String State;

    public void setPid(){
        this.pid = pid;
    }
    public int getPid(){
        return pid;
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

