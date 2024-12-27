package cn.mzyao.cloud.controller;

import cn.hutool.core.util.StrUtil;
import cn.mzyao.cloud.entitys.pojo.SeataUserOrder;
import cn.mzyao.cloud.feign.Api01FeignClient;
import cn.mzyao.cloud.service.SeataUserOrderService;
import cn.mzyao.cloud.service.SysConfigService;
import cn.mzyao.cloud.tools.enums.ProductInfo;
import cn.mzyao.cloud.tools.result.Result;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@AllArgsConstructor
@RequestMapping("/seata/user/order")
public class SeataUserOrderController {

    private Api01FeignClient api01FeignClient;

    private SeataUserOrderService seataUserOrderService;

    private SysConfigService sysConfigService;

    /**
     * 数据库连通性测试
     * @return
     */
    @GetMapping("config")
    public Result<?> getConfig(){
        return Result.success(sysConfigService.list());
    }

    /**
     * 购买商品
     * @return
     */
    @PostMapping("trade")
    @GlobalTransactional(rollbackFor = Exception.class)
    public Result<?> trade(String productName, Integer userId) {
        if (StrUtil.isEmpty(productName)) {
            return Result.fail("商品名称不能为空");
        }
        ProductInfo productInfo = ProductInfo.getEnumByValue(productName);
        if (productInfo == null) {
            return Result.fail("商品不存在");
        }

        // 新增 订单
        SeataUserOrder seataUserOrder = new SeataUserOrder();
        seataUserOrder.setUserId(userId);
        seataUserOrder.setOrderAmount(productInfo.getPrice());
        seataUserOrder.setStatus("1");
        seataUserOrder.setCreatedAt(LocalDateTime.now());
        seataUserOrderService.save(seataUserOrder);

        // 扣减用户余额
        return api01FeignClient.userBalanceDecrease(userId, seataUserOrder.getOrderAmount());
    }

}
