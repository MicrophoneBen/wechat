package com.ghostben.wechat.demo.wechat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: wechat
 * @description: SpringBoot测试类。Hello测试
 * @author: ghostben
 * @create: 2018-11-25 15:08
 **/
@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String helloController(){
        System.out.println("Hello SpirngMVC");
        return "Hello Spring Boot";
    }
}