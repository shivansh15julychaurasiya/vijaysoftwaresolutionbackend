package com.vijay;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class Appliation {

	
	 @Autowired
	    private Environment environment;
	 
	public static void main(String[] args) {
		SpringApplication.run(Appliation.class, args);
	}
	
	   @PostConstruct
	    public void logActiveProfile() {
	        String[] profiles = environment.getActiveProfiles();
	        System.out.println("✅ Active Profile(s): " + String.join(", ", profiles));
	    }

}
