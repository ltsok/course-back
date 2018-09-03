package com.lts.course.dao;

import com.lts.course.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
