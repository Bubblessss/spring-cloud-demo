package com.zh.eurekacustomerfeignhystrix.controller;

import com.springcloud.entity.User;
import com.zh.eurekacustomerfeignhystrix.service.DcClient;
import feign.Feign;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;

/**
 * 服务消费者(feign)
 * @author zhanghang
 * @date 2018/2/26
 */
@Slf4j
@RestController
public class DcController {

    @Autowired
    private DcClient dcClient;

    @GetMapping("/customer")
    public String dc(){
        return this.dcClient.customer();
    }

    @GetMapping("/sendFile")
    public String sendFile() throws IOException {
        File file = new File(this.getClass().getResource("/data.txt").getPath());
        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file",
                MediaType.TEXT_PLAIN_VALUE, true, file.getName());
        try {
            InputStream input = new FileInputStream(file);
            OutputStream os = fileItem.getOutputStream();
            IOUtils.copy(input, os);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        MultipartFile multi = new CommonsMultipartFile(fileItem);
//        DcClient dcClient = Feign.builder().encoder(new FeignSpringFormEncoder()).target(DcClient.class, "/uploadFile");
        return dcClient.sendFile(multi);
    }

    @PostMapping("/saveUser")
    public String saveUser(User user){
        return this.dcClient.saveUser(user);
    }

    @GetMapping("/updateById")
    public String updateById(Integer id){
        return this.dcClient.updateById(id);
    }
}
