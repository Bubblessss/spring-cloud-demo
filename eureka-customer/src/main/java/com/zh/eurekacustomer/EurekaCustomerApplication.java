package com.zh.eurekacustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务消费者(LoadBalancerClient)
 * @author zhanghang
 * @date 2018/2/24
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaCustomerApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
