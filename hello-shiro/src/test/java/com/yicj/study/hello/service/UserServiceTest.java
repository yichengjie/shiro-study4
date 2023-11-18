package com.yicj.study.hello.service;

import com.yicj.study.hello.HelloApplication;
import com.yicj.study.hello.repository.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest(classes = HelloApplication.class)
class UserServiceTest {

    @Autowired
    private UserService userService ;

    @Test
    public void list(){
        List<User> list = userService.list();
        list.forEach(item -> log.info("item : {}", item));
    }

}