package com.study.doctorhelper;

import java.time.ZonedDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DoctorHelperApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(DoctorHelperApplication.class, args);
		
		System.out.println(ZonedDateTime.now());
	}

}
