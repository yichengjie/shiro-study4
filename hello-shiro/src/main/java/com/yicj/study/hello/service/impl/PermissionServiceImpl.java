package com.yicj.study.hello.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yicj.study.hello.repository.entity.Permission;
import com.yicj.study.hello.service.PermissionService;
import com.yicj.study.hello.repository.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author yichengjie
* @description 针对表【sys_permission】的数据库操作Service实现
* @createDate 2023-11-18 19:38:01
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService{

}




