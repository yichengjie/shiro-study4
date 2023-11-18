package com.yicj.study.hello.shiro;

import com.yicj.study.hello.repository.entity.User;
import com.yicj.study.hello.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.*;

/**
 * @author yicj
 * @Since 2023/11/18 22:48
 */
@RequiredArgsConstructor
public class AuthRealm extends AuthorizingRealm {

    private final UserService userService ;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) principals.fromRealm(this.getClass().getName()).iterator().next();
        Set<String> permissionList = new HashSet<>() ;
        // todo
        // 循环遍历user的角色信息
        // 循环便利role的permission信息
        // 填充permissionList集合
        permissionList.add("userAdd") ;
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(permissionList);
        return authorizationInfo;
    }

    // 认证登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token ;
        String username = usernamePasswordToken.getUsername();
        User user = userService.findByUsername(username);
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }
}
