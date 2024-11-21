package com.example.customermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CustomerManagementApp {
	@RequestMapping("/")
        String home(){
                System.out.println("User move to home");
                return "Hello world!";
        }
	public static void main(String[] args) {
		// DemoController controller = new DemoController();
		SpringApplication.run(CustomerManagementApp.class, args);
	}

}
