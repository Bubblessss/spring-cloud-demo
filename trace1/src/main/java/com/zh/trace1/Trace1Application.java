package com.zh.trace1;

import com.sun.istack.internal.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 分布式服务跟踪客户端
 * @author zhanghang
 * @date 2018/3/2
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class Trace1Application {
	private final Logger logger = Logger.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(Trace1Application.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@GetMapping("/trace-1")
	public String trace(){
		logger.info("=================trcee1================");
		return restTemplate().getForObject("http://trace-2/trace-2",String.class);
	}
}
