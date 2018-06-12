package com.zh.eurekacustomerribbonhystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 断路器客户端(hystrix依赖于ribbon)
 * @author zhanghang
 * @date 2018/2/24
 */
@Service
public class CustomerService  {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String customer(){
        return this.restTemplate.getForObject("http://eureka-provider/home",String.class);
    }

    public String fallback(){
        return "fallback";
    }

    /**
     * @HystrixCollapser :
     * Hystrix提供的请求合并注解，在自定义的时间窗内合并请求，默认10ms,可以有效的减少网络连接数量和提高系统的吞吐量
     * 适用场景:时间窗内高并发，单个请求耗时 >> 时间窗
     * @param id
     * @return
     */
    @HystrixCollapser(batchMethod = "getUserByIds",collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds",value = "10")
    })
    public User getUserById(Integer id){
        return this.restTemplate.getForObject("http://eureka-provider/getUserById",User.class);
    }

    public List<User> getUserByIds(List<Integer> ids){
        return this.restTemplate.getForObject("http://eureka-provider/getUserByIds/" + ids,List.class);
    }
}
