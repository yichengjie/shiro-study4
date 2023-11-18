package com.yicj.study.hello.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yicj.study.hello.repository.entity.User;
import com.yicj.study.hello.service.UserService;
import com.yicj.study.hello.repository.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author yichengjie
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2023-11-18 19:25:04
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public User findByUsername(String username) {
        return this.lambdaQuery()
                .eq(User::getUsername, username)
                .one() ;
    }
}




