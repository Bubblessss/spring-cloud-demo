package com.zh.eurekacustomerribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务消费者(ribbon)
 * @author zhanghang
 * @date 2018/2/24
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaCustomerRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaCustomerRibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
