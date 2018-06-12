package com.zh.eurekaprovider;

import com.springcloud.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * 服务提供方
 * @author zhanghang
 * @date 2018/2/23
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProviderApplication.class, args);
	}

	@GetMapping("/home")
	public String home() throws InterruptedException {
		System.out.println("=====================进入EurekaProviderHome======================");
		//睡5s触发hystrix默认熔断机制
//		TimeUnit.SECONDS.sleep(5);
		return "Hello world";
	}

	@PostMapping("/uploadFile")
	public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) throws IOException {
		System.out.println("=====================进入EurekaProviderUploadFile======================");
		file.transferTo(new File("D:\\" + file.getName()));
		return file.getName();
	}

	@PostMapping("/saveUser")
	public String saveUser(User user){
		System.out.println("=====================进入EurekaProviderSaveUser======================");
		return user.getName();
	}

	@GetMapping("/updateById")
	public String updateById(Integer id){
		System.out.println("=====================进入EurekaProviderUpdateById======================");
		return "update by id = " + id;
	}

}
