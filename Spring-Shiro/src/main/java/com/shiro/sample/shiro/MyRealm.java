package com.shiro.sample.shiro;

import com.hazelcast.util.MD5Util;
import com.shiro.sample.model.User;
import com.shiro.sample.utils.ShiroMD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;
import java.util.Set;

/**
 * 自定义的Realm
 */
public class MyRealm extends AuthorizingRealm {

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //  1、获取当前对象用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();

        //  2、根据用户名查询当前用户
        User user = getPasswordFromDb(username);

        //  3、判断用户是否存在
        if (user == null) {
            throw new RuntimeException("用户不存在异常");
        }
        //  4、创建信息认证对象，Shiro会自动比对用户名与密码，不匹配将抛出密码不正常异常
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, user.getPassword(), this.getName());
        //  info.setCredentialsSalt(ByteSource.Util.bytes("i_am_salt"));//框架----自动加盐----验证
        return info;
    }


    /**
     * 模拟---根据用户名---从数据库查询当前用户
     */
    private User getPasswordFromDb(String username) {
        User user = new User();
        if (username.equals("admin")) {
            user.setUsername("admin");
            // user.setPassword("123456");
            user.setPassword(ShiroMD5Util.md5Andsalt("123456"));//数据库中MD5加盐后的密码
            return user;
        } else {
            user.setUsername("xxxxxx");
            // user.setPassword("666666");
            user.setPassword(ShiroMD5Util.md5Andsalt("666666"));
            return user;
        }
    }

//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //  1、获取当前用户用户名
        String username = (String) principalCollection.getPrimaryPrincipal();

        //  2、从查询当前用户的角色/权限
        Set<String> roles = getRoleFromDb(username);
        Set<String> perms = getPermissionFromDb(username);

        //  3、设置角色、权限
        info.setStringPermissions(perms);
        info.setRoles(roles);

        return info;
    }


    private Set<String> roles;
    private Set<String> perms;
    /**
     * 模拟---根据用户名---从数据库查询---角色
     */
    private Set<String> getRoleFromDb(String username) {
        roles = new HashSet<>();
        roles.add("admin");
        roles.add("teacher");
        roles.add("student");
        return roles;
    }
    /**
     * 模拟---根据用户名---从数据库查询---权限
     */
    private Set<String> getPermissionFromDb(String username) {
        perms = new HashSet<>();
        perms.add("add");
        perms.add("delete");
        perms.add("update");
        perms.add("query");
        return perms;
    }



}
