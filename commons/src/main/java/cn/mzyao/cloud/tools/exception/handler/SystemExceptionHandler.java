package cn.mzyao.cloud.tools.exception.handler;


import cn.mzyao.cloud.tools.exception.BusinessException;
import cn.mzyao.cloud.tools.exception.GatewayException;
import cn.mzyao.cloud.tools.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class SystemExceptionHandler {

    /**
     * 网关错误异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(GatewayException.class)
    public Result<?> businessExceptionHandler(GatewayException e) {
        log.error("网关错误异常处理", e);
        return Result.fail(e.getCode(), e.getMessage());
    }

    /**
     * 全局业务异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public Result<?> businessExceptionHandler(BusinessException e) {
        log.error("全局业务异常处理", e);
        return Result.fail(e.getCode(), e.getMessage());
    }


    /**
     * 全局系统异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result<?> businessExceptionHandler(Exception e) {
        log.error("全局系统异常处理", e);
        return Result.fail(e.getMessage());
    }


}
