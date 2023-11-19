package com.yicj.study.hello.controller;

import com.yicj.study.hello.repository.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author yicj
 * @Since 2023/11/19 8:46
 */
@Slf4j
@Controller
public class HelloController {

    @RequestMapping("/login")
    public String login(){
        return "login" ;
    }

    @RequestMapping("/index")
    public String index(){
        return "index" ;
    }

    @RequestMapping("/loginUser")
    public String loginUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password) ;
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            session.setAttribute("user", user);
            return "index";
        }catch (Exception e){
            log.error("====> User login error : ", e);
            return "login" ;
        }
    }
}
