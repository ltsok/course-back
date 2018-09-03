package com.lts.course.controller;

import com.lts.course.entity.User;
import com.lts.course.service.IUserService;
import com.lts.course.utils.Result;
import com.lts.course.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;


@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class TestBootController {
    @Autowired
    private IUserService userService;

    @GetMapping("/showUser/{id}")
    public Result toIndex(@PathVariable() Integer id){
        Logger logger = Logger.getLogger(TestBootController.class);
        int userId = id;
        User user = this.userService.getUserById(userId);
//        throw new ResultException(ResultCode.SUCCESS);
        logger.info("ltsok");
//        System.out.println(TestBootController.ge);
        return ResultUtils.success(user);
    }
}
