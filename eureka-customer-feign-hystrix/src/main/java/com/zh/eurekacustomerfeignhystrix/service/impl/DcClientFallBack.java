package com.zh.eurekacustomerfeignhystrix.service.impl;

import com.springcloud.entity.User;
import com.zh.eurekacustomerfeignhystrix.service.DcClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 服务消费者(feign)
 * @author zhanghang
 * @date 2018/2/26
 */
@Service
public class DcClientFallBack implements DcClient {
    @Override
    public String customer() {
        return "fallback";
    }

    @Override
    public String sendFile(MultipartFile file) {
        return "上传失败!";
    }

    @Override
    public String saveUser(User user) {
        return "保存用户失败!";
    }

    @Override
    public String updateById(Integer id) {
        return "更新失败!";
    }
}
