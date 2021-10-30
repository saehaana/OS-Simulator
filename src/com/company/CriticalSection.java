package com.company;

public class CriticalSection{
    /**Will contain at least one critical section and critical section resolving scheme
     * Ensures shared resource to be accessed by one process at a time**/

    public void Crit(){

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