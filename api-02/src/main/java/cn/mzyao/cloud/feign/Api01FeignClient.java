package cn.mzyao.cloud.feign;

import cn.mzyao.cloud.config.FeignConfig;
import cn.mzyao.cloud.entitys.pojo.SysConfig;
import cn.mzyao.cloud.tools.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@FeignClient(value = "api01-server", configuration = FeignConfig.class)
public interface Api01FeignClient {

    @GetMapping("/api01/v1/index")
    Result<?> api01Index();

    @GetMapping("/api01/config/pojo/getById/{id}")
    SysConfig getConfigById(@PathVariable("id") Long id);

    /**
     * 扣除用户金额
     *
     * @param userId
     * @param money
     * @return
     */
    @PostMapping(value = "/api01/seata/user/balance/decrease", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    Result userBalanceDecrease(@RequestPart("userId") Integer userId,
                               @RequestPart("money") BigDecimal money);

}
