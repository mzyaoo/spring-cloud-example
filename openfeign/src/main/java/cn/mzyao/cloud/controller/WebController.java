package cn.mzyao.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    /**
     * 测试
     *
     * @return
     */
    @GetMapping("index")
    public String index() {
        return "Hello,OpenFeign";
    }

}
