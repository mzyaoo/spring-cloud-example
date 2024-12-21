package cn.mzyao.cloud.controller;

import cn.mzyao.cloud.service.SysConfigService;
import cn.mzyao.cloud.tools.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("config")
public class SysConfigController {

    @Resource
    private SysConfigService sysConfigService;

    @GetMapping("count")
    public Result<Long> getConfig() {
        long count = sysConfigService.count();
        return Result.success(count);
    }

}
