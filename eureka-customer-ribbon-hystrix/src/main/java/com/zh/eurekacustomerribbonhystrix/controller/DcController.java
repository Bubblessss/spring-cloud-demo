package com.zh.eurekacustomerribbonhystrix.controller;

import com.zh.eurekacustomerribbonhystrix.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 断路器客户端(hystrix依赖于ribbon)
 * @author zhanghang
 * @date 2018/2/24
 */
@RestController
public class DcController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public String dc(){
        return this.customerService.customer();
    }
}
