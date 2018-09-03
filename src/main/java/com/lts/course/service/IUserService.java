package com.lts.course.service;

import com.lts.course.entity.User;
import com.lts.course.utils.Result;

import java.util.List;

public interface IUserService {
    User getById(String userId);
    Result addUser(User user);
    Result deleteUser(String userId);
}
