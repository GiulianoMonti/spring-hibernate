package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component("sillyPractice")
public class SoccerCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice shoots to the goal";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
