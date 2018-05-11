package com.xxx.mb.controller;

import com.xxx.mb.mapper.UserMapper;
import com.xxx.mb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/insertUser")   //  增
    @ResponseBody
    public String insert() {
        User user = new User();
        user.setUsername("FGQ");
        user.setPassword("FGQ");
        userMapper.insertUser(user);
        return "success:-------" + user.getUid();
    }

    @RequestMapping("/deleteUser/{uid}") //  删
    @ResponseBody
    public String delete(@PathVariable("uid") Integer uid) {
        userMapper.deleteUseById(uid);
        return "success";
    }

    @RequestMapping("/updateUser/{uid}/{username}")  //  改
    @ResponseBody
    public String update(@PathVariable("uid") Integer uid, @PathVariable("username") String username) {
        User user = new User();
        user.setUid(uid);
        user.setUsername(username);
        userMapper.updateuser(user);
        return "success";
    }

    @RequestMapping("/queryUser1/{uid}")  //  查1：User
    @ResponseBody
    public User queryUser(@PathVariable("uid") Integer uid) {
        User user = userMapper.findUserById(uid);
        return user;
    }

    @RequestMapping("/queryUser2")  //  查2：Count
    @ResponseBody
    public String queryCount() {
        Integer userCount = userMapper.findUserCount();
        return String.valueOf(userCount);
    }


    @RequestMapping("/queryUser3/{name}")  //  查3：模糊查询
    @ResponseBody
    public List<User> queryUsers(@PathVariable("name") String name) {
        List<User> list = userMapper.findUserLikeName(name);
        return list;
    }

    @RequestMapping("/queryUser4")  //  查4：一对多查询
    @ResponseBody
    public List<User> queryUserOrders() {
        List<User> list = userMapper.queryUserOrders();
        return list;
    }
}
