package com.lts.course.dao;

import com.lts.course.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserDao {

    User getById(String userId);

    void addUser(User record);

    void deleteUser(String userId);
}
