package cn.mzyao.cloud.controller;


import cn.mzyao.cloud.entitys.pojo.SeataUser;
import cn.mzyao.cloud.service.SeataUserService;
import cn.mzyao.cloud.tools.result.Result;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("seata")
public class SeataUserController {

    @Resource
    private SeataUserService seataUserService;

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping("/user/list")
    public Result<?> getSeataUser(){
        List<SeataUser> list = seataUserService.list();
        return Result.success(list);
    }

    /**
     * 用户余额扣减
     *
     * @return
     */
    @PostMapping("/user/balance/decrease")
    public Result<?> userBalanceDe(Integer userId, BigDecimal money) {
        LambdaQueryWrapper<SeataUser> queryWrapper = Wrappers.lambdaQuery(SeataUser.class).eq(SeataUser::getId, userId);
        SeataUser user = seataUserService.getOne(queryWrapper);
        if (user == null) {
            return Result.fail("用户不存在！");
        }
        BigDecimal balance = user.getBalance();
        if (balance.compareTo(money) < 0) {
            return Result.fail("余额不足！");
        }
        user.setBalance(balance.subtract(money));
        seataUserService.updateById(user);
        return Result.success();
    }

}
