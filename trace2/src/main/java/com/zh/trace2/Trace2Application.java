package com.zh.trace2;

import com.sun.istack.internal.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分布式服务跟踪客户端
 * @author zhanghang
 * @date 2018/3/2
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class Trace2Application {
	private final Logger logger = Logger.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(Trace2Application.class, args);
	}

	@GetMapping("/trace-2")
	public String trace(){
		logger.info("=================trcee2================");
		return "trace-2";
	}
}
