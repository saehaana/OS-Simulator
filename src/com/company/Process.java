package com.company;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Process{
    private int Cycle;
    public static int resource = 0;

    /**Program will read program file/template as input
     * Input will generate processes of random cycle length for each operation
     * Operations include:
     *      CALCULATE - run process in run state for cycle(s) (simulates CPU resource usage)
     *      I/O       - put process in wait state for cycle(s)**/
    public void setCycle(int newCycle){
        this.Cycle = newCycle;
    }
    public Collection<? extends Integer> getCycle(){
        return Collections.singleton(Cycle);
    }

}