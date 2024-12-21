package cn.mzyao.cloud.controller;

import cn.mzyao.cloud.feign.Api01FeignClient;
import cn.mzyao.cloud.feign.GatewayServerFeignClient;
import cn.mzyao.cloud.tools.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class FeignController {

    private GatewayServerFeignClient gatewayServerFeignClient;

    private Api01FeignClient api01FeignClient;

    @GetMapping("gateway/index")
    public String gatewayIndex(){
        return gatewayServerFeignClient.gatewayIndex();
    }

    @GetMapping("api01/index")
    public Result<?> api01Index(){
        return api01FeignClient.api01Index();
    }

}
