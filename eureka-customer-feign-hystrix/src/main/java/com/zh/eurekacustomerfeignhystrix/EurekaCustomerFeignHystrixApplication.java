package com.zh.eurekacustomerfeignhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 断路器客户端(feign版)
 * @author zhanghang
 * @date 2018/2/26
 */
@SpringCloudApplication
@EnableFeignClients
public class EurekaCustomerFeignHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaCustomerFeignHystrixApplication.class, args);
	}
}
