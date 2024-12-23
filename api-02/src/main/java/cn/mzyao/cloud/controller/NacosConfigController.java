package cn.mzyao.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/nacos/config")
public class NacosConfigController {

    @Value("${data}")
    private String nacosId;

    @Value("${mybatis}")
    private String mybatis;

    @GetMapping("/data")
    public String data(){
        return mybatis;
    }


}
