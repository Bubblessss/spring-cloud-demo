package com.zh.eurekacustomerfeignhystrix.service;

import com.springcloud.entity.User;
import com.zh.eurekacustomerfeignhystrix.config.MultipartSupportConfig;
import com.zh.eurekacustomerfeignhystrix.service.impl.DcClientFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 服务消费者(feign)
 * @author zhanghang
 * @date 2018/2/26
 */
@FeignClient(name = "eureka-provider",fallback = DcClientFallBack.class,configuration = MultipartSupportConfig.class)
public interface DcClient {

    @GetMapping("/home")
    String customer();

    /**
     * 如果当前接口指定了具体的encode方式，
     * 文件上传没问题，但是其他post请求，就会包encode错误
     * @param file
     * @return
     */
    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    String sendFile(@RequestPart(value = "file") MultipartFile file);

    @PostMapping("/saveUser")
    String saveUser(@RequestBody User user);

    @GetMapping("/updateById")
    String updateById(@RequestParam("id") Integer id);

}
