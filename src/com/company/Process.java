/**Program will read program file/template as input
 * Input will generate processes of random cycle length for each operation
 * Operations include:
 * CALCULATE - run process in run state for cycle(s) (simulates CPU resoure usage)
 * I/O - put process in wait state for cycle(s)**/

package com.company;

public class Process{
    private int CPU;

    public void setCPU(int newCycle){
        this.CPU = newCycle;
    }
    public int getCPU(){
        return CPU;
    }
}