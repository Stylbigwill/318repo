package com.henryschein.dataservices;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.henryschein.dataservices.service.impl.DataServiceImpl;

@SpringBootApplication
public class DataServicesApplication {
	@Named
	public static class JerseyConfig extends ResourceConfig {
		public JerseyConfig() {
			this.register(DataServiceImpl.class);
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(DataServicesApplication.class, args);
	}

}
