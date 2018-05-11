package com.xxx.mb.mapper;

import com.xxx.mb.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //  增
    void insertUser(User user);

    //  删
    void deleteUseById(Integer id);

    //  改
    void updateuser(User user);

    //  单个查询
    User findUserById(Integer id);

    //  查询总数
    Integer findUserCount();

    //  模糊查询
    List<User> findUserLikeName(@Param("name")String name);

    //  一对多查询
    List<User> queryUserOrders();

}
