package com.lts.course.service.imp;

import com.lts.course.dao.IUserDao;
import com.lts.course.entity.User;
import com.lts.course.service.IUserService;
import com.lts.course.utils.Result;
import com.lts.course.utils.ResultCode;
import com.lts.course.utils.ResultUtils;
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


    public User getById(String userId) {
        return userDao.getById(userId);
    }

    public Result addUser(User user){

        //校验用户名
        if (!user.checkUserName()) {
            return ResultUtils.warn(ResultCode.PARAMETER_ERROR, "用户名格式不正确");
        }

        userDao.addUser(user);
        return ResultUtils.success(null);
    }

    public Result deleteUser(String userId) {
        userDao.deleteUser(userId);
        return ResultUtils.success(null);
    }
}
