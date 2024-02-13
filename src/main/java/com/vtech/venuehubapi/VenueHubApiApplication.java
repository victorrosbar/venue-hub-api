package com.vtech.venuehubapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class VenueHubApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VenueHubApiApplication.class, args);
	}

}
