package com.nacos.example.feigninter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : songhn
 * @className: FeignApi
 * @company : Boboqi Software Co.,Ltd.
 * @date : 2019-03-25 18:07
 * @description: <p>测试Feign客户端</p>
 */
@FeignClient(name = "service-provider", configuration = FooConfiguration.class)
public interface FeignApi {

    /**
     * 测试Feign客户端
     *
     * @param str
     * @return
     */
    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    String echo(@PathVariable(value = "str") String str);

}
