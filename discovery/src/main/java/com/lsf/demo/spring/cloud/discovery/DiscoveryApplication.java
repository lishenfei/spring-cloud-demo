package com.lsf.demo.spring.cloud.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //1 开启Eureka服务端的支持
public class DiscoveryApplication {

	  public static void main(String[] args) {
	        SpringApplication.run(DiscoveryApplication.class, args);
	    }

}
