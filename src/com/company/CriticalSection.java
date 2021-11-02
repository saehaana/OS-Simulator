/**Critical Section - Ensures shared resource to be accessed by one process at a time
 * Each process has critical section segment of code
 * Each template for loaded application will have text CRIT_START and CRIT_END, to simulate process manipulating variable, update table, etc**/

package com.company;

import java.util.concurrent.Semaphore;

public class CriticalSection{
    public static Semaphore semaphore = new Semaphore(1); //number of allowed threads in Semaphore is 1;
    private boolean signal = false;

    //sends signal
    public synchronized void take(){
        this.signal = true;
        this.notify();
    }
    //waits for signal
    //when received, signal flag cleared again and release() exits
    public synchronized void release() throws InterruptedException {
        while(!this.signal){
            wait();
        }
        this.signal = false;
    }
}