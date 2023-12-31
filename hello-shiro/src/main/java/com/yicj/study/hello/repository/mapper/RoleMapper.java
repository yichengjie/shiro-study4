package com.yicj.study.hello.repository.mapper;

import com.yicj.study.hello.repository.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author yichengjie
* @description 针对表【sys_role】的数据库操作Mapper
* @createDate 2023-11-18 19:23:06
* @Entity com.yicj.study.hello.entity.Role
*/
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> listByUserId(@Param("userId") Integer userId) ;
}




