package com.zh.eurekacustomerribbonhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 断路器客户端(ribbon+restTemplate版)
 * @SpringCloudApplication 集成了
 * {@SpringBootApplication、@EnableEurekaClient、@EnableHystrix}
 * @author zhanghang
 * @date 2018/2/24
 */
//@SpringBootApplication
//@EnableEurekaClient
//@EnableHystrix
@SpringCloudApplication
public class EurekaCustomerRibbonHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaCustomerRibbonHystrixApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
