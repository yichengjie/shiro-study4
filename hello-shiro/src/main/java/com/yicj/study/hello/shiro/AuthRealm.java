package com.yicj.study.hello.shiro;

import com.yicj.study.hello.repository.entity.Permission;
import com.yicj.study.hello.repository.entity.Role;
import com.yicj.study.hello.repository.entity.User;
import com.yicj.study.hello.service.PermissionService;
import com.yicj.study.hello.service.RoleService;
import com.yicj.study.hello.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yicj
 * @Since 2023/11/18 22:48
 */
@RequiredArgsConstructor
public class AuthRealm extends AuthorizingRealm {

    private final UserService userService ;

    private final RoleService roleService ;

    private final PermissionService permissionService ;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) principals.fromRealm(this.getClass().getName()).iterator().next();
        List<Role> roleList = roleService.listByUserId(user.getId());
        List<Integer> roleIdList = roleList.stream()
                .map(Role::getId)
                .collect(Collectors.toList());
        List<Permission> permissionList = permissionService.listByRoleIdList(roleIdList);
        //
        Set<String> permissionNameList = permissionList.stream()
                .map(Permission::getName)
                .collect(Collectors.toSet());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(permissionNameList);
        //
        Set<String> roleNameList = roleList.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
        authorizationInfo.setRoles(roleNameList);
        return authorizationInfo;
    }

    // 认证登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token ;
        String username = usernamePasswordToken.getUsername();
        User user = userService.findByUsername(username);
        if (user == null){
            throw new RuntimeException("用户名不存在!") ;
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }
}
