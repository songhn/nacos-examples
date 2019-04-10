package com.nacos.example;

import com.nacos.example.filter.CoustomFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : songhn
 * @className: Application
 * @company : Boboqi Software Co.,Ltd.
 * @date : 2019-04-08 12:38
 * @description: <p>TODO</p>
 */
@EnableZuulProxy
@SpringCloudApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CoustomFilter coustomFilter(){
        return new CoustomFilter();
    }

    @RestController
    class EchoController {

        @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
        public String echo(@PathVariable String string) {
            log.info("我是网关服务[8888]-echo");
            return "Hello Nacos Discovery " + string;
        }
    }

}
