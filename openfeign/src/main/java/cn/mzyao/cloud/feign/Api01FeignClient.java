package cn.mzyao.cloud.feign;

import cn.mzyao.cloud.entitys.pojo.SysConfig;
import cn.mzyao.cloud.tools.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("api01-server")
public interface Api01FeignClient {

    @GetMapping("/api01/v1/index")
    Result<?> api01Index();

    @GetMapping("/api01/config/pojo/getById/{id}")
    SysConfig getConfigById(@PathVariable("id") Long id);

}
