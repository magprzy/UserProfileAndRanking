package com.capgemini.userProfileAndRanking.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Configuration
@Component
public class TimeAspekt {

	private static final Logger LOGGER = LoggerFactory.getLogger(TimeAspekt.class);
	long start;
	 
	
	@Before ("execution(* com.capgemini.userProfileAndRanking.*.*.*.*(..))")
	public void beforeExecution(JoinPoint joinPoint){
		start = System.currentTimeMillis();
	}
	
	@After ("execution(* com.capgemini.userProfileAndRanking.*.*.*.*(..))")
	public void afterExecution(JoinPoint joinPoint){
		long end = System.currentTimeMillis();
		
		long time = end - start;
		
		LOGGER.info("Execution time: " + time);
		System.out.println("Execution time: " + time);
	}
	
	
	
}
