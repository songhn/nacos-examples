package com.nacos.example;

import com.nacos.example.feigninter.FeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : songhn
 * @className: Application
 * @company : Boboqi Software Co.,Ltd.
 * @date : 2019-03-25 16:05
 * @description: <p>Springcloud服务消费者</p>
 */
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class Application {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * @author : songhn
     * @className: Application
     * @company : Boboqi Software Co.,Ltd.
     * @date : 2019-03-25 16:09
     * @description: <p>TODO</p>
     */
    @RestController
    public class TestController {
        private final RestTemplate restTemplate;

        @Autowired
        public TestController(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        @Autowired
        private FeignApi feignApi;

        @RequestMapping(value = "/echo/1/{str}", method = RequestMethod.GET)
        public String echo1(@PathVariable(value = "str") String string) {
            return restTemplate.getForObject("http://service-provider/echo/" + string, String.class);
        }

        @RequestMapping(value = "/echo/2/{str}", method = RequestMethod.GET)
        public String echo2(@PathVariable(value = "str") String string) {
            return feignApi.echo(string);
        }
    }

}
