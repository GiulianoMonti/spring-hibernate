package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
	private String fileName = "/Users/giulianodanielmonti/Desktop/Hibernate and Spring/spring-activity5/src/com/luv2code/springdemo/activity.txt";

	File theFile = new File(fileName);
	private Random myRandom = new Random();

	private List<String> list = new ArrayList<>();

	public FileFortuneService() throws IOException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(theFile))) {
			String tempLine;
			while ((tempLine = br.readLine()) != null) {
				list.add(tempLine);
			}

		}
	}

	@Override
	public String getFortune() {


		
		int index = myRandom.nextInt(list.size());

		String randomFromList = list.get(index);

		return randomFromList;
	}

}
