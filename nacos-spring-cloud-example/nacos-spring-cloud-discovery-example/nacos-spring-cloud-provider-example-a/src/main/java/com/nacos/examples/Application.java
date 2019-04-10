package com.nacos.examples;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : songhn
 * @className: Application
 * @company : Boboqi Software Co.,Ltd.
 * @date : 2019-03-25 16:00
 * @description: <p>Springcloud 服务提供者</p>
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    class EchoController {

        @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
        public String echo(@PathVariable String string) {
            log.info("我是集群服务[18080]");
            return "Hello Nacos Discovery " + string;
        }

    }

}
