package com.nacos.example.feigninter;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : songhn
 * @className: FooConfiguration
 * @company : Boboqi Software Co.,Ltd.
 * @date : 2019-03-26 12:40 
 * @description: <p>覆盖Feign的默认配置</p>
 */
@Configuration
public class FooConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
