package com.lts.course.service.imp;

import com.lts.course.dao.IUserDao;
import com.lts.course.entity.User;
import com.lts.course.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限实体类
 * @author ltsok
 * @date 2018/8/30
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;


    public User getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    public boolean addUser(User record){
        boolean result = false;
        try {
            userDao.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
