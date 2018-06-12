package com.zh.eurekacustomerfeign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 服务消费者(feign)
 * @author zhanghang
 * @date 2018/2/24
 */
@FeignClient("eureka-provider")
public interface DcClient {

    @GetMapping("/home")
    String customer();
}
