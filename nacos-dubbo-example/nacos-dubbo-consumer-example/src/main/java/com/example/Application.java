package com.example;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : songhn
 * @className: Application
 * @company : Boboqi Software Co.,Ltd.
 * @date : 2019-04-10 15:28
 * @description: <p>服务消费方</p>
 */

@SpringBootApplication
@EnableDubboConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
