package com.company;

import java.util.concurrent.Semaphore;

public class CriticalSection{
    /**Will contain at least one critical section and critical section resolving scheme
     * Ensures shared resource to be accessed by one process at a time**/

    private Semaphore mutex = new Semaphore(1); //number of allowed threads in Semaphore is 1

    public void cs(){
        try{
            mutex.acquire();
        }catch(InterruptedException e){
            //exception handling code
        }finally{
            mutex.release();
        }
    }
}
/**wait() and signal()

 wait(int m_semaphore){
 while(m_semaphore <= 0);
 m_semaphore--;
 }

 //do critical section stuff
 signal(int m_semaphore){
 m_semaphore++;
 }**/