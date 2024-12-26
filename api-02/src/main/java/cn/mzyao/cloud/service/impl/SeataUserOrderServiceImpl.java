package cn.mzyao.cloud.service.impl;

import cn.mzyao.cloud.entitys.pojo.SeataUserOrder;
import cn.mzyao.cloud.mybatis.mapper.SeataUserOrderMapper;
import cn.mzyao.cloud.service.SeataUserOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SeataUserOrderServiceImpl extends ServiceImpl<SeataUserOrderMapper, SeataUserOrder> implements SeataUserOrderService {
}
