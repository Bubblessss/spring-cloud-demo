package com.zh.eurekacustomerfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 服务消费者(feign)
 * @author zhanghang
 * @date 2018/2/24
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class EurekaCustomerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaCustomerFeignApplication.class, args);
	}
}
