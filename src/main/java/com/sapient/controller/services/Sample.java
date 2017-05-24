package com.sapient.controller.services;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;
import com.sapient.controller.aspects.Loggable;
import com.sapient.controller.aspects.Loggable.Level;

@Component
public class Sample {
	

	
	public String doStuff()
	{
		try {
			TimeUnit.MILLISECONDS.sleep(2);			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("do Stuff console");
		return "Hi";
	
		
	}

	
	public void newdoStuff()
	{
		try {
			TimeUnit.MILLISECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("new do Stuff console");
	
		
	}
}
