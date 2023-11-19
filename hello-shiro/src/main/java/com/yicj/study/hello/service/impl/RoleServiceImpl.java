package com.yicj.study.hello.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yicj.study.hello.repository.entity.Role;
import com.yicj.study.hello.service.RoleService;
import com.yicj.study.hello.repository.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yichengjie
* @description 针对表【sys_role】的数据库操作Service实现
* @createDate 2023-11-18 19:23:06
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

    @Override
    public List<Role> listByUserId(Integer userId) {
        return this.baseMapper.listByUserId(userId);
    }
}




