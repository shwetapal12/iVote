package com.timer;

import java.util.Timer;
import java.util.TimerTask;

public class Application {

	public static Application obj;
	public static void main(String[] args) {
		
		obj = new Application(); 
        
        // creating an instance of timer class 
        Timer timer = new Timer(); 
          
        // creating an instance of task to be scheduled 
        TimerTask task = new TimerDemo(); 
          
        // scheduling the timer instance 
        timer.schedule(task, 1000, 3000); 
          
        // fetching the scheduled execution time of  
        // the most recent actual execution of the task 
        System.out.println(task.scheduledExecutionTime()); 
          
        synchronized(obj) 
        { 
            //this thread waits until i reaches 4 
            try {
				obj.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        } 
          
        //canceling the task assigned  
        System.out.println("Cancel the timer task: " + task.cancel()); 
          
        // at this point timer is still running  
        // without any task assigned to it 
      
        // canceling the timer instance created 
        timer.cancel(); 

}
}

