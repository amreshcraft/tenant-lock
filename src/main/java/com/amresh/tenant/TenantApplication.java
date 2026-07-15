package com.amresh.tenant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TenantApplication {

	public static void main(String[] args) {
		System.out.println("Hello Tenants");
		SpringApplication.run(TenantApplication.class, args);

	}

}
