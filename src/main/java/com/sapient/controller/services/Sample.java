package com.sapient.controller.services;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import com.sapient.controller.aspects.Loggable;


@Component
public class Sample {
	
	@Autowired
	private Environment env;

	
	public String doStuff()
	{
		try {
			
			System.out.println(env.getProperty("myuser.name"));
			TimeUnit.MILLISECONDS.sleep(2);			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("do Stuff console");
		return "Hi";
	
		
	}

	
	@Loggable
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
