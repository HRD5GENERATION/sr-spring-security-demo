package com.sr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sr.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityThymeleafDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringSecurityThymeleafDemoApplication.class, args);
		
		UserRepository repo = context.getBean(UserRepository.class);
		System.out.println(repo.loadUserByUsername("dps"));
		
	}
}
