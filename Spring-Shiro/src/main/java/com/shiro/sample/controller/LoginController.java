package com.shiro.sample.controller;

import com.shiro.sample.model.User;
import com.shiro.sample.utils.ShiroMD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String index() {
        return "/login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(User param, HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(param.getUsername(), ShiroMD5Util.md5Andsalt(param.getPassword()));
        token.setRememberMe(param.isRememberme());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    /**
     * 注解测试
     */
    @RequestMapping("/roleTest")
    @ResponseBody
    @RequiresRoles("admin")
    public String roleTest() {
        return "roleTest:  success";
    }

    /**
     * 自定义过滤器测试
     */
    @RequestMapping("/roleOrTest")
    @ResponseBody
    public String roleOrTest() {
        return "roleOrTest:  success";
    }

}
