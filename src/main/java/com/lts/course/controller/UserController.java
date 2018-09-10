package com.lts.course.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lts.course.conf.Access;
import com.lts.course.entity.User;
import com.lts.course.service.IUserService;
import com.lts.course.utils.Result;
import com.lts.course.utils.ResultUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@EnableAutoConfiguration
@RequestMapping("/users")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @GetMapping("/all")
    @Access(operation = "查询所有用户")
    public Result allUsers() {
        logger.info("query all user");
        List<User> user = this.userService.getAll();
        return ResultUtils.success(user);
    }

    @GetMapping("/{id}")
    @Access(operation = "查询单个用户")
    public Result user(@PathVariable("id") String id) throws InterruptedException {
        logger.info("query single user");
        String userId = id;
        Thread.sleep(5000);
        User user = this.userService.getById(userId);
        logger.info("ltsok");
        return ResultUtils.success(user);
    }

    @PostMapping("/addUser")
    @Access(operation = "新增用户")
    public Result save(@RequestBody String params) throws IOException {
        logger.info("add user");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        User user = mapper.readValue(params, User.class);
        Result result = userService.addUser(user);
        return result;
    }

    @DeleteMapping("/deleteUser")
    @Access(operation = "删除用户")
    public Result delete(@RequestBody String[] params) throws IOException {
        logger.info("delete user");
//        if (params == null || params.length <= 0) {
//            return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
//        }
        System.out.println(params);
        Result result = userService.deleteUser("");
        return result;
    }

    @PutMapping("/updateUser")
    @Access(operation = "修改用户信息")
    public Result update(@RequestBody String params ) throws IOException {
        logger.info("modify user");
        ObjectMapper mapper = new ObjectMapper();
        //忽略不匹配的字段
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        User user = mapper.readValue(params, User.class);
        Result result = userService.updateUser(user);
        return result;
    }
}
