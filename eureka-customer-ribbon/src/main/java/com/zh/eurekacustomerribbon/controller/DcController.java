package com.zh.eurekacustomerribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 服务消费者(ribbon)
 * @author zhanghang
 * @date 2018/2/24
 */
@RestController
public class DcController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/customer")
    public String dc(){
        return this.restTemplate.getForObject("http://eureka-provider/home",String.class);
    }
}
