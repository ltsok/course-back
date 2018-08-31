package com.lts.course.service;

import com.lts.course.entity.User;

import java.util.List;

public interface IUserService {
    User getUserById(int userId);
    boolean addUser(User user);
}
