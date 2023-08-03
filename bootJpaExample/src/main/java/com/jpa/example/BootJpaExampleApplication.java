package com.jpa.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.jpa.example.dao.UserRepo;
import com.jpa.example.mdl.UserModel;

@SpringBootApplication
public class BootJpaExampleApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(BootJpaExampleApplication.class, args);

		UserRepo bean = context.getBean(UserRepo.class);

		UserModel usermdl = new UserModel();
		usermdl.setName("Ram");
		usermdl.setCity("Ayodhya");
		usermdl.setStatus("OK");

		UserModel save = bean.save(usermdl);
		System.out.println("From main method ==>>> " + save);

	}

}
