package cn.mzyao.cloud.controller;

import cn.mzyao.cloud.entitys.pojo.SysConfig;
import cn.mzyao.cloud.feign.Api01FeignClient;
import cn.mzyao.cloud.tools.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/feign/api01")
public class Api01Controller {

    @Resource
    private Api01FeignClient api01FeignClient;


    @GetMapping("/config")
    public Result<?> api01Config(){
        SysConfig configById = api01FeignClient.getConfigById(1l);
        return Result.success(configById);
    }

}
