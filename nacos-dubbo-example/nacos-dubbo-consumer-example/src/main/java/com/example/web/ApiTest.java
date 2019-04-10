package com.example.web;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.nacos.example.DemoApi;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : songhn
 * @className: ApiTest
 * @company : Boboqi Software Co.,Ltd.
 * @date : 2019-04-10 15:30
 * @description: <p>TODO</p>
 */
@Slf4j
@RestController
public class ApiTest {

    @Reference(version = "1.0.0", check = false)
    public DemoApi demoApi;

    /**
     * @param value
     * @return
     */
    @GetMapping("/test/{value}")
    public String test(@PathVariable String value) {
        log.info("ApiTest======>");
        RpcContext.getContext().setAttachment("span_id", String.valueOf(RandomUtils.nextLong()));
        String newValue = demoApi.helloNacos(value);
        return newValue;
    }
}
