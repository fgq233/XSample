package com.shiro.sample.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * URL拦截：自定义过滤器
 */
public class MyShiroFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {

        Subject subject = getSubject(servletRequest, servletResponse);

        String [] roles = (String[]) o;

        if(roles == null || roles.length == 0){// 无需任何角色就可以访问
            return true;
        }
        for (String role : roles){
            if(subject.hasRole(role)){//    shiro中配置多个角色的拦截器默认必须具有所有角色才能访问，此处设置具有多个角色中的一个角色就可以访问
                return true;
            }
        }
        return false;
    }

}
