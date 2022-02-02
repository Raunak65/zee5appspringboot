package com.zee.zee5app;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.service.UserService;

public class RegisterRepoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext applicationContext = 
				SpringApplication.run(RegisterRepoTest.class, args);
		
		UserService userservice = applicationContext.getBean(UserService.class);
		
		
		
		applicationContext.close();

	}

}
