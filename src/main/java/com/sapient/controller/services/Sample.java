package com.sapient.controller.services;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;
import com.sapient.controller.aspects.Loggable;
import com.sapient.controller.aspects.Loggable.Level;

@Component
public class Sample {
	

	
	public void doStuff()
	{
		try {
			TimeUnit.MILLISECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("do Stuff console");
	
		
	}

}
