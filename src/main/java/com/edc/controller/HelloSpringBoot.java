package com.edc.controller;

import com.edc.entry.SpringBootMysqlTest;
import com.edc.mapper.SpringBootMysqlInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试springboot的控制器
 */

@RestController   //代表注解成rest风格的格式
//@Controller   //将重定向到页面
public class HelloSpringBoot {

    //注解一个接口进来
    @Autowired
    SpringBootMysqlInterface springBootMysqlInterface;

    @RequestMapping("/say")
    public String say(){
        return "hello spring boot!!!";
    }

    @RequestMapping("/list")
    public List<SpringBootMysqlTest> listMysql(){
        return springBootMysqlInterface.list();
    }
}
