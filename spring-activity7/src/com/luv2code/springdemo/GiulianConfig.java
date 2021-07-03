package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:mylogger.properties")
public class GiulianConfig {
	
	@Bean
	public MyLoggerConfig myLoggerConfig(@Value("${root.logger.level}") String rootLoggerLevel,
										 @Value("${printed.logger.level}") String printedLoggerLevel) {

		MyLoggerConfig myLoggerConfig = new MyLoggerConfig(rootLoggerLevel, printedLoggerLevel);

		return myLoggerConfig;
	}

	
	// define bean for our sad fortune service
	@Bean
	public FortuneService megaHappyFortuneService() {
		return new MegaHappyFortuneService();
	}

	// define bean for our swim coach AND inject dependency
	@Bean
	public Coach giulianCoach() {
		GiulianCoach myGiulianCoach = new GiulianCoach(megaHappyFortuneService());

		return myGiulianCoach;
	}

}



