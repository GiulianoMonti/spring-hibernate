package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GiulianApp {

	public static void main(String[] args) {
		// read spring config java class
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(GiulianConfig.class);
		
		// get the bean from spring container
		GiulianCoach theCoach = context.getBean("giulianCoach", GiulianCoach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
				
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
			

		// close the context
		context.close();
		
	}

}


