package com.yicj.study.hello.service;

import com.yicj.study.hello.repository.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author yichengjie
* @description 针对表【sys_user】的数据库操作Service
* @createDate 2023-11-18 19:25:04
*/
public interface UserService extends IService<User> {

    User findByUsername(String username) ;
}
