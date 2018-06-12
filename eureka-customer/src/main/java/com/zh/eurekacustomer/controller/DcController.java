package com.zh.eurekacustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 服务消费者(LoadBalancerClient)
 * @author zhanghang
 * @date 2018/2/24
 */
@RestController
public class DcController {

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/customer")
    public String dc(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("eureka-provider");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/home";
        return this.restTemplate.getForObject(url,String.class);
    }

}
