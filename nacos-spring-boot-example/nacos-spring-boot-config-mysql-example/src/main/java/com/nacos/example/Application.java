package com.nacos.example;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : songhn
 * @className: Application
 * @company : Boboqi Software Co.,Ltd.
 * @date : 2019-03-22 17:18
 * @description: <p>启动类</p>
 */
@SpringBootApplication
@NacosPropertySource(dataId = "mysql.properties", autoRefreshed = true)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
