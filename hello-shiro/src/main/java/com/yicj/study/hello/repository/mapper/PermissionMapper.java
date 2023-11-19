package com.yicj.study.hello.repository.mapper;

import com.yicj.study.hello.repository.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author yichengjie
* @description 针对表【sys_permission】的数据库操作Mapper
* @createDate 2023-11-18 19:38:01
* @Entity com.yicj.study.hello.repository.entity.Permission
*/
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> listByRoleIdList(@Param("roleIdList") List<Integer> roleIdList) ;
}




