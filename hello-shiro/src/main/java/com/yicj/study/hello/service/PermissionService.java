package com.yicj.study.hello.service;

import com.yicj.study.hello.repository.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author yichengjie
* @description 针对表【sys_permission】的数据库操作Service
* @createDate 2023-11-18 19:38:01
*/
public interface PermissionService extends IService<Permission> {

    List<Permission> listByRoleIdList(List<Integer> roleIdList);
}
