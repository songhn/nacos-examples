package example.imple;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.nacos.example.DemoApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author : songhn
 * @className: DemoApiImple
 * @company : Boboqi Software Co.,Ltd.
 * @date : 2019-04-10 15:14
 * @description: <p>服务提供者</p>
 */
@Slf4j
@Component
@Service(interfaceClass = DemoApi.class, version = "1.0.0", timeout = 1000, loadbalance = "roundrobin")
public class DemoApiImple implements DemoApi {
    @Override
    public String helloNacos(String value) {
        log.info("Nacos-Dobbu-Provider-b");
        log.info("span_id=" + RpcContext.getContext().getAttachment("span_id"));
        return "Hello Nacos;Value=" + value;
    }
}
