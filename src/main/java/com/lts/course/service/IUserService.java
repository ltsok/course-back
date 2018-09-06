package com.lts.course.service;

import com.lts.course.entity.User;
import com.lts.course.utils.Result;

import java.util.List;

public interface IUserService {

    /**
     * 查询所有用户
     * @return List
     */
    List<User> getAll();

    /**
     * 根据Id查询用户
     * @param userId
     * @return User
     */
    User getById(String userId);

    /**
     * 新增用户
     * @param user
     * @return Result
     */
    Result addUser(User user);

    /**
     * 删除用户
     * @param userId
     * @return Result
     */
    Result deleteUser(String userId);

    /**
     * 修改用户
     * @param user
     * @return Result
     */
    Result updateUser(User user);
}

