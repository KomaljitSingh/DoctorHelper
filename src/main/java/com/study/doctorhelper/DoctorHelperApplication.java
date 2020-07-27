package com.study.doctorhelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DoctorHelperApplication {

//	@Bean
//	public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DoctorHelperApplication.class, args);
		System.out.println("application context is -------  "+ctx);
		
	}

}
