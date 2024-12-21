package cn.mzyao.cloud.feign;

import cn.mzyao.cloud.tools.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("api01-server")
public interface Api01FeignClient {

    @GetMapping("/api01/v1/index")
    Result<?> api01Index();

}
