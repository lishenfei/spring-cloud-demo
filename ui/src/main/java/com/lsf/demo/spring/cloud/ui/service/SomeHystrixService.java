package com.lsf.demo.spring.cloud.ui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 使用 Ribbon 调用 Person Service, 并使用断路器
 */
@Service
public class SomeHystrixService {

	@Autowired
	RestTemplate restTemplate; //在 Spring Boot 环境中使用 Ribbon, 只需注入 RestTemplate 即可，Spring Boot 已经为我们做好了负载均衡的配置

	@HystrixCommand(fallbackMethod = "fallbackSome") //本方法调用失败时，调用后备方法fallbackSave
	public String getSome() {
		return restTemplate.getForObject("http://some/getsome", String.class);
	}
	
	public String fallbackSome(){ 
		return "some service模块故障";
	}
}
