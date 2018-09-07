package com.lts.course.dao;

import com.lts.course.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {

    //获取所有用户
    List<User> getAll();

    //获取单个用户
    User getById(String userId);

    //添加用户
    void addUser(User record);

    //删除用户
    void deleteUser(String userId);

    //修改用户
    void updateUser(User user);
}
