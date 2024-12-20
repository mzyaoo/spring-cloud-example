package cn.mzyao.cloud.controller;

import cn.mzyao.cloud.tools.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class WebController {

    /**
     * 测试
     * @return
     */
    @GetMapping("index")
    public Result<?> index(){
        return Result.success("Hello,World");
    }

}
