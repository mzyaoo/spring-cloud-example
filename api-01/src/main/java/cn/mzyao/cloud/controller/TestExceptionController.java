package cn.mzyao.cloud.controller;

import cn.mzyao.cloud.tools.enums.ResponseCode;
import cn.mzyao.cloud.tools.exception.BusinessException;
import cn.mzyao.cloud.tools.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test/ex")
public class TestExceptionController {


    /**
     * 手动抛出业务异常
     * @param isEx
     * @return
     */
    @GetMapping("business")
    public Result<String> businessException(Boolean isEx) {
        if (isEx) {
            throw new BusinessException(ResponseCode.SYSTEM_ERROR);
        }
        return Result.success();
    }

    /**
     * 系统错误
     * @param isEx
     * @return
     */
    @GetMapping("system")
    public Result<String> systemException(Boolean isEx) {
        if (isEx) {
            System.out.println(1 / 0);
        }
        return Result.success();
    }

}
