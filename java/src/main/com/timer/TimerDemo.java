package com.timer;

import java.util.Date;
import java.util.TimerTask;

public class TimerDemo extends TimerTask {

	public static int  count=1;
	Date d= new Date();
	Date d1= new Date(5000L);
	@Override
	public void run() {
	System.out.println("running application"+ ++count+" times");
	System.out.println(d);
	//System.out.println(d.getMinutes());
	
	//if(d.getMinutes()>20) 
    { 
        synchronized(Application.obj) 
        { 
            Application.obj.notify(); 
        } 
    } 
		
	}

}
