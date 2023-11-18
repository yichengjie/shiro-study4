package com.yicj.study.hello.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @author yicj
 * @Since 2023/11/18 22:59
 */
public class AuthCredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token ;
        String password = new String(usernamePasswordToken.getPassword());
        //
        String dbPassword = (String) info.getCredentials();
        return dbPassword.equals(password);
    }
}
