package cn.mzyao.cloud.controller;

import cn.hutool.core.util.StrUtil;
import cn.mzyao.cloud.service.SysConfigService;
import cn.mzyao.cloud.tools.enums.ProductInfo;
import cn.mzyao.cloud.tools.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/seata/user/order")
public class SeataUserOrderController {

    @Resource
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
    public Result<?> trade(String productName){
        if (StrUtil.isEmpty(productName)){
            return Result.fail("商品名称不能为空");
        }
        ProductInfo productInfo = ProductInfo.getEnumByValue(productName);
        return Result.success(productInfo.toString());
    }

}
