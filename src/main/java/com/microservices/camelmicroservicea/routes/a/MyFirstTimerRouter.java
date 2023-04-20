package com.microservices.camelmicroservicea.routes.a;

import java.time.LocalDateTime;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component 
public class MyFirstTimerRouter extends RouteBuilder{
	
	@Autowired
	private GetCurrentTimeBean getCurrentTimeBean;

	@Override
	public void configure() throws Exception {
		// queue / timer
		// processing / transformation
		// database / log
		
		// processing - no change to body of the message
		// transformation - change to body of the message
		
		from("timer:first-timer")
		//.transform().constant("Time now is"+LocalDateTime.now())
		.bean(getCurrentTimeBean,"getCurrentTime")
		.to("log:first-timer");
		
	}

}

@Component
class GetCurrentTimeBean{
	public String getCurrentTime()
	{
		return "Time now is"+LocalDateTime.now();
	}
}
