package com.zh.eurekacustomerfeign.controller;

import com.zh.eurekacustomerfeign.service.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务消费者(feign)
 * @author zhanghang
 * @date 2018/2/24
 */
@RestController
public class DcController {

    @Autowired
    private DcClient dcClient;

    @GetMapping("/customer")
    public String dc(){
        return this.dcClient.customer();
    }
}
