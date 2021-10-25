Summary

This is a semester long project where students are to simulate an operating system by means of a program. Done in any language of choosing, the operating system simulator was worked on in three phases and consisted of four main components.

Phase 1 - Process Management:

Phase 2 - Memory Management:

Phase 3 - Bonus and GUI:

How To Run

The OS simulator was created using IntelliJ IDE and as of right now there is no executable. So the only way to run the program is to save all files to a folder and execute Main.java from within the IDE. One thing to note is the inclusion of the BufferedReader class to read text from specified templates/program files. Your version of the OS simulator will not run correctly if you do not change the file paths of the templates to your download's directory. If you do not change the file path directory, BufferedReader will not be able to read correctly and therefore processes and their associated operations cannot be properly set. 

Implemented Solutions

To simulate an operating system and its components, the idea of separate java files working together was an ideal approach. Code was encapsulated into separate classes and represented by names such as PCB, Processor, Scheduler, etc. Each class had their own setter and getter methods which was used to manipulate their class's object(s) and return certain I/O.

Process: 

PCB: Will retrieve and store all information pertaining to OS components; mainly consisting of information about each process e.g., process state, pid, CPU registers, etc

Scheduler: The scheduling algorithm used is the Round Robin (RR) approach. This simulator's RR contains a time quantum of q = 4(ms). Once the first process enters the queue, the scheduler will execute the process for one time quantum. If there are other processes in the queue, then the current process being executed will be preempted and the next process in queue will execute for one time quantum. If no other processes exist but the first in queue, then more time quanta will be given for the process to complete its execution and terminate or return to ready state.  

Critical Section: Will also include critical section resolving scheme. This component ensures that shared resources are to be accessed by one process at a time. If one process is executing, then others have to wait to execute in their own critical sections.

Software Requirement(s): Latest version of IntelliJ IDE

Hardware Requirement(s): Working computer
