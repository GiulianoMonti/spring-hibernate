package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
	private String fileName = "/Users/giulianodanielmonti/Desktop/Hibernate and Spring/spring-activity5/src/com/luv2code/springdemo/activity.txt";

	File theFile = new File(fileName);
	private Random myRandom = new Random();

	private List<String> list = new ArrayList<>();

	public FileFortuneService() throws IOException, IOException {
		System.out.println(">> FileFortuneService: inside default constructor");

	}

	@PostConstruct
	public void doMyStartupStuff() throws IOException, IOException {
		
		System.out.println("Reading fortunes from file: " + theFile);
		System.out.println("File exists: " + theFile.exists());
		
		try (BufferedReader br = new BufferedReader(new FileReader(theFile))) {
			String tempLine;
			while ((tempLine = br.readLine()) != null) {
				list.add(tempLine);
			}

		}
	}
	// define my destroy method

	public void doMyCleanupStuff() {
	}

	@Override
	public String getFortune() {
		
		int index = myRandom.nextInt(list.size());

		String randomFromList = list.get(index);

		return randomFromList;
	}

}
