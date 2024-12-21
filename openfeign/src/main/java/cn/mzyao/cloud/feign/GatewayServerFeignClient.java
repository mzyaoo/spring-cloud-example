package cn.mzyao.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("gateway-server")
public interface GatewayServerFeignClient {

    @GetMapping("/index")
    String gatewayIndex();

}
