package cn.mzyao.cloud.service.impl;

import cn.mzyao.cloud.entitys.pojo.SysConfig;
import cn.mzyao.cloud.mybatis.mapper.SysConfigMapper;
import cn.mzyao.cloud.service.SysConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {
}
