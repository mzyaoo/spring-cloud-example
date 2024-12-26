package cn.mzyao.cloud.service.impl;

import cn.mzyao.cloud.entitys.pojo.SeataUser;
import cn.mzyao.cloud.mybatis.mapper.SeataUserMapper;
import cn.mzyao.cloud.service.SeataUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SeataUserServiceImpl extends ServiceImpl<SeataUserMapper, SeataUser> implements SeataUserService {

}
